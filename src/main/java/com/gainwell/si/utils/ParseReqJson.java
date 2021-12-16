package com.gainwell.si.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gainwell.si.domain.Root;
import org.springframework.stereotype.Component;

@Component
public class ParseReqJson {

    public Root parseJson(String requestJson) {

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = null;

        try {
            root = mapper.readValue(requestJson, Root.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

            throw new IllegalStateException("Unable to parse the JSON - " + e.getMessage());

        }

        return root;
    }

}
