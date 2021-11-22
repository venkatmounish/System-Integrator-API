package com.gainwell.si.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gainwell.si.domain.*;
import com.gainwell.si.utils.SchemaValidator;

import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

@RestController
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateProviderController {


    @Autowired
    SchemaValidator schemaValidator;

    @Autowired
    Root root;

    @Autowired
    Envelope envelope;

    @Autowired
    Body body;

    @Autowired
    CreateProviderResponse createProviderResponse;

    @Autowired
    MessageHeader messageHeader;

    @PostMapping(value = "/api/createProvider", consumes = "application/json", produces = "application/json")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ResponseEntity<Object> createProvider(@RequestBody String requestJson) throws FileNotFoundException {
        //ResponseEntity<String>

        /*Set<ValidationMessage> validationResult = schemaValidator.validateJson("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\providerJsonSchema.json",
                requestJson);*/

        File file = ResourceUtils.getFile("classpath:providerJsonSchema.json");
        Set<ValidationMessage> validationResult = schemaValidator.validateJson(file.getPath(),
                requestJson);

        String responseCode = null;
        String responseType = null;
        String responseMsg = null;
        String msgDetails = null;
        HttpStatus httpStatusCode = null;

        if (validationResult.isEmpty()) {

            System.out.println("There is no validation errors");

            //     schemaValidation = "Success";
            responseCode = "200";
            responseType = "Success";
            responseMsg = "Request Processed successfully";
            httpStatusCode = HttpStatus.ACCEPTED;

        } else {

            //  validationResult.forEach(vm -> System.out.println(vm.getMessage() +" === " + vm.getDetails() + " === "
            //  + vm.getCode() + " ====  " +vm.getPath()  + " ====  " +vm.getType() +  " ====  " +vm.getArguments() + vm));

            for (ValidationMessage vm : validationResult) {
                // schemaValidation = "Failure";
                responseCode = vm.getCode();
                String msg = vm.getMessage();
                responseType = "Failure";
                responseMsg = msg.substring(msg.lastIndexOf(".") + 1).replace(":", "");

                String path = vm.getPath().substring(1).replace(".", "/");
                msgDetails = "The request received has errors and could not be processed. Please correct the request " +
                        "and resend for processing. Error at path - " + path;

                httpStatusCode = HttpStatus.EXPECTATION_FAILED;


            }

            // schemaValidation = "Failure";
        }

        createProviderResponse.setResponseCode(responseCode);
        createProviderResponse.setResponseType(responseType);
        createProviderResponse.setResponseMessage(responseMsg);
        createProviderResponse.setResponseDetails(msgDetails);
        createProviderResponse.setSITransactionKey(messageHeader.getSITransactionKey());
        createProviderResponse.setModuleTransactionId(messageHeader.getModuleTransactionId());

        body.setCreateProviderResponse(createProviderResponse);
        envelope.setBody(body);
        root.setEnvelope(envelope);

        return new ResponseEntity<>(root, httpStatusCode);
        //  return envelope;
    }

}
