package com.gainwell.si.service;

import com.gainwell.si.domain.*;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import com.gainwell.si.utils.ValidateSchema;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SchemaValidateService {

    @Autowired
    ValidateSchema validateSchema;

    @Autowired
    Root root;

  /*  @Autowired
    CreateProviderResponse createProviderResponse;*/


    @Autowired
    ParseReqJson parseReqJson;


    public ResponseEntity<Object> schemaValidator(String requestJson) throws IOException {

        InputStream jsonSchemaStream = new ClassPathResource("providerJsonSchema.json").getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(jsonSchemaStream, baos);
        byte[] jsonSchemaBytes = baos.toByteArray();
        ByteArrayInputStream schemaFile = new ByteArrayInputStream(jsonSchemaBytes);

        Set<ValidationMessage> validationResult = validateSchema.validateJson(schemaFile,
                requestJson);

        String responseCode;
        String responseType;
        String responseMsg;
        String msgDetails;
        HttpStatus httpStatusCode;
        List<CreateProviderResponse> createProviderResponseList = new ArrayList();

        root = parseReqJson.parseJson(requestJson);
        MessageHeader messageHeader = root.getCreateProvider().getMessageHeader();

        root.setSITransactionKey(messageHeader.getSITransactionKey());
        root.setModuleTransactionId(messageHeader.getModuleTransactionId());
        root.setResponseTimestamp(Utils.getCurrentTimestamp());

        long validationResultSetSize = validationResult.size();

        if (validationResultSetSize==0) {

            System.out.println("There are no validation errors");

            responseCode = "200";
            responseType = "Success";
            responseMsg = "Request Processed successfully";
            httpStatusCode = HttpStatus.ACCEPTED;

            root.setResponseCode(responseCode);
            root.setResponseMessage(responseMsg);

          //  root.setFailedValidations(null);
            System.out.println("root.getFailedValidations() ==> "+root.getFailedValidations());

        } else {

            int counter = 0;
            root.setFailedValidations(validationResultSetSize);
            for (ValidationMessage vm : validationResult) {

                counter++;

                String msg = vm.getMessage();
                responseMsg = msg.substring(msg.lastIndexOf(".") + 1).replace(":", "");

                String path = vm.getPath().substring(1).replace(".", "/");
                msgDetails = "The request received has errors and could not be processed. Please correct the request " +
                        "and resend for processing. Error at path - " + path;

                responseCode = vm.getCode();

                CreateProviderResponse createProviderResponse = new CreateProviderResponse();
                
                createProviderResponse.setResponseCode(responseCode);
                createProviderResponse.setResponseMessage(responseMsg);
                createProviderResponse.setResponseDetails(msgDetails);
                createProviderResponse.setSequenceNumber(counter);


                createProviderResponseList.add(createProviderResponse);
            }

            root.setCreateProviderResponse(createProviderResponseList);
            responseType = "Failure";
            httpStatusCode = HttpStatus.EXPECTATION_FAILED;

        }

        root.setResponseType(responseType);

        root.setCreateProvider(null);
        return new ResponseEntity<>(root, httpStatusCode);
    }
}
