package com.gainwell.si.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.gainwell.si.domain.*;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersionDetector;
import com.networknt.schema.ValidationMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

@Component
public class SchemaValidator {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageHeader messageHeader;

    public Set<ValidationMessage> validateJson(String schemaFile, String requestJson) {


        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonSchemaNode = null;
        try {
            jsonSchemaNode = mapper.readTree(new File(schemaFile));
        } catch (IOException e) {
            logger.error(String.format("Unable to find the schema file at %s - %S", schemaFile, e.getMessage()));
            e.printStackTrace();
        }

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.builder(JsonSchemaFactory.getInstance(SpecVersionDetector.detect(jsonSchemaNode))).objectMapper(mapper).build();

        JsonSchema schema = null;
        try {
            schema = schemaFactory.getSchema(new FileInputStream(schemaFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(requestJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String siTxnKey = jsonNode.at("/Envelope/Body/CreateProvider/MessageHeader/SITransactionKey").textValue();
        messageHeader.setSITransactionKey(siTxnKey);

        String moduleTxnId = jsonNode.at("/Envelope/Body/CreateProvider/MessageHeader/ModuleTransactionId").textValue();
        messageHeader.setModuleTransactionId(moduleTxnId);

        Set<ValidationMessage> validationResult = schema.validate(jsonNode);
        //  String schemaValidation;


        // return schemaValidation;
        return validationResult;
    }
}
