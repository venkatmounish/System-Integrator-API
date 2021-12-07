package com.gainwell.si.service;

import com.gainwell.si.domain.ProviderInformation;
import com.gainwell.si.domain.Root;
import com.gainwell.si.domain.SubscriberA;
import com.gainwell.si.domain.SubscriberB;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import javafx.concurrent.Task;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
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
        try {
            responseEntity = schemaValidateService.schemaValidator(requestJson);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // TODO: ADD LOGGING
        }

        ResponseEntity<Object> finalResponseEntity = responseEntity;

        new Thread() {
            @SneakyThrows
            public void run() {
                if (finalResponseEntity.getStatusCode() == HttpStatus.ACCEPTED) {

                    siRequestsService.insertSIRequests(requestJson);

                    Root root = parseReqJson.parseJson(requestJson);
                    // System.out.println(root);
                   // ProviderInformation providerInformation = root.getEnvelope().getBody().getCreateProvider().getPayload().getProviderInformation();

                    ProviderInformation providerInformation = root.getCreateProvider().getPayload().getProviderInformation();

                    // System.out.println(providerInformation);
                    try {
                      /*  CompletableFuture<SubscriberA> subA = subscriberService.genSubAMsg(providerInformation);
                        System.out.println("Inside create provider service -===========");
                     //   System.out.println(subA.get());
                        CompletableFuture<SubscriberB> subB = subscriberService.genSubBMsg(providerInformation);*/

                        CompletableFuture.runAsync(() -> {
                            try {
                                subscriberService.genSubAMsg(providerInformation);
                            } catch (ExecutionException e) {
                                e.printStackTrace();

                                // TODO: ADD LOGGING
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        });

                        CompletableFuture.runAsync(() -> {
                            try {
                                subscriberService.genSubBMsg(providerInformation);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        });

                        CompletableFuture.runAsync(() -> {
                            try {
                                subscriberService.genSubCMsg(providerInformation);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        });


                        //    utils.saveAsFile(subA.get());
                        //   utils.saveAsFile(subB.get());

                    } catch (Throwable e) {
                        throw e.getCause();
                    }


                }
                System.out.println("END TIME: " + utils.getCurrentTimestamp());

                System.out.println(finalResponseEntity);
            }
        }.start();


        return responseEntity;
    }

}



