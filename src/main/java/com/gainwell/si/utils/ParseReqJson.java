package com.gainwell.si.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gainwell.si.domain.Envelope;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.gainwell.si.domain.Root;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
public class ParseReqJson {

    public Root parseJson(String requestJson) {

        ObjectMapper mapper = new ObjectMapper();
        Root root = null;

        try {
            root = mapper.readValue(requestJson, Root.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return root;
    }

/*    public static void main(String[] args) throws IOException {

        ParseReqJson parseReqJson = new ParseReqJson();
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\t158463\\Documents\\workspace\\System-Integrator-API\\src\\main\\resources\\Publisher-Request.json")));

        System.out.println(content);

      Root root =  parseReqJson.parseJson(content);

        System.out.println(root.getEnvelope().getBody().getCreateProvider().getMessageHeader().getModuleTransactionId());
    }*/

}
