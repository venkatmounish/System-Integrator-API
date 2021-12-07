package com.gainwell.si.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gainwell.si.domain.MessageHeader;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersionDetector;
import com.networknt.schema.ValidationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;

@Component
public class ValidateSchema {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageHeader messageHeader;

    public Set<ValidationMessage> validateJson(ByteArrayInputStream schemaFile, String requestJson) {


        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonSchemaNode = null;
        try {
            schemaFile.reset();
            jsonSchemaNode = mapper.readTree(schemaFile);
        } catch (IOException e) {
            logger.error(String.format("Unable to find the schema file at %s - %S", schemaFile, e.getMessage()));
            e.printStackTrace();
        }

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.builder(JsonSchemaFactory.getInstance(SpecVersionDetector.detect(jsonSchemaNode))).objectMapper(mapper).build();

        JsonSchema schema = null;
        schemaFile.reset();
        schema = schemaFactory.getSchema(schemaFile);

        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(requestJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* String siTxnKey = jsonNode.at("/Envelope/Body/CreateProvider/MessageHeader/SITransactionKey").textValue();
        messageHeader.setSITransactionKey(siTxnKey);

        String moduleTxnId = jsonNode.at("/Envelope/Body/CreateProvider/MessageHeader/ModuleTransactionId").textValue();
        messageHeader.setModuleTransactionId(moduleTxnId);
*/
        Set<ValidationMessage> validationResult = schema.validate(jsonNode);
        //  String schemaValidation;


        // return schemaValidation;
        return validationResult;
    }
}
