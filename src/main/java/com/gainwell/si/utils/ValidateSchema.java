package com.gainwell.si.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersionDetector;
import com.networknt.schema.ValidationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Set;

@Component
public class ValidateSchema {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Set<ValidationMessage> validateJson(ByteArrayInputStream schemaFile, String requestJson) {


        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonSchemaNode = null;
        try {
            schemaFile.reset();
            jsonSchemaNode = mapper.readTree(schemaFile);
        } catch (IOException e) {
            logger.error(String.format("Unable to find the schema file at %s - %S", schemaFile, e.getMessage()));
            e.printStackTrace();

            throw new IllegalStateException("Unable to find the schema file - " + e.getMessage());

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

            throw new IllegalStateException("Unable to process requestJson - " + e.getMessage());
        }

        Set<ValidationMessage> validationResult = schema.validate(jsonNode);

        return validationResult;
    }
}
