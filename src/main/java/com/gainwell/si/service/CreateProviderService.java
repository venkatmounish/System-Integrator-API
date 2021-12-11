package com.gainwell.si.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gainwell.si.domain.ProviderInformation;
import com.gainwell.si.domain.Root;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class CreateProviderService {

    @Autowired
    SchemaValidateService schemaValidateService;

    @Autowired
    SIRequestsService siRequestsService;

    @Autowired
    ParseReqJson parseReqJson;

    @Autowired
    SubscriberService subscriberService;

    @Autowired
    Utils utils;

    @SneakyThrows
    public ResponseEntity<Object> createProviderSvc(String requestJson) {


        System.out.println("START TIME: " + utils.getCurrentTimestamp());

        ResponseEntity<Object> responseEntity = null;
        responseEntity = schemaValidateService.schemaValidator(requestJson);

        ResponseEntity<Object> finalResponseEntity = responseEntity;

        new Thread() {
            @SneakyThrows
            public void run() {
                if (finalResponseEntity.getStatusCode() == HttpStatus.ACCEPTED) {

                    siRequestsService.insertSIRequests(requestJson);

                    Root root = parseReqJson.parseJson(requestJson);
                    ProviderInformation providerInformation = root.getCreateProvider().getPayload().getProviderInformation();
                    String txnId = root.getCreateProvider().getMessageHeader().getSITransactionKey();

                    try {

                        CompletableFuture.runAsync(() -> {

                            try {
                                subscriberService.genSubAMsg(providerInformation, txnId);
                            } catch (ExecutionException | InterruptedException | IOException e) {
                                e.printStackTrace();
                                throw new IllegalStateException(e.getMessage());
                            }
                            // TODO: ADD LOGGING



                        });

                        CompletableFuture.runAsync(() -> {
                            try {
                                subscriberService.genSubBMsg(providerInformation, txnId);
                            } catch (ExecutionException | InterruptedException | IOException e) {
                                e.printStackTrace();
                                throw new IllegalStateException(e.getMessage());
                            }

                        });

                        CompletableFuture.runAsync(() -> {
                            try {
                                subscriberService.genSubCMsg(providerInformation, txnId);
                            } catch (ExecutionException | InterruptedException | IOException e) {
                                e.printStackTrace();
                                throw new IllegalStateException(e.getMessage());
                            }

                        });


                        //    utils.saveAsFile(subA.get());
                        //   utils.saveAsFile(subB.get());

                    } catch (Throwable e) {
                        throw e.getCause();

                    }


                }

            }
        }.start();


        return responseEntity;
    }

}



