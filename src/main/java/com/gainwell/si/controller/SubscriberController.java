package com.gainwell.si.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gainwell.si.domain.CreateProviderResponse;
import com.gainwell.si.domain.Root;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Api(value = "Submit Provider Information", tags = "API call to submit provider information")
@Tag(name = "Process Provider Information", description = "API call to process provider information by a subscriber")
@OpenAPIDefinition(tags = {
        @Tag(name = "widget", description = "Widget operations."),
        @Tag(name = "gasket", description = "Operations related to gaskets")
})
public class SubscriberController {

    @Autowired
    ParseReqJson parseReqJson;

    private HttpStatus httpStatusCode;

    @ApiOperation(value = "Submit Provider Information", response = CreateProviderResponse.class)
    @Tag(name = "Process Provider Information by a subscriber")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Provider info submitted"),
            @ApiResponse(code = 202, message = "Provider info processed"),
            @ApiResponse(code = 401, message = "You are not authorized to perform this operation"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping(value = "/api/consumeProvider", consumes = "application/json", produces = "application/json")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ResponseEntity<Object> createProvider(@RequestBody String requestJson) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Root root = null;
        root = parseReqJson.parseJson(requestJson);
        String provId = root.getCreateProvider().getPayload().getProviderInformation().getProviderDemographics().getProviderId();

        if (provId.equalsIgnoreCase("Prov624342")) {

            InputStream jsonSchemaStream = new ClassPathResource("SubAError_1.json").getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(jsonSchemaStream, baos);
            byte[] err1Bytes = baos.toByteArray();
            ByteArrayInputStream err1 = new ByteArrayInputStream(err1Bytes);

            err1.reset();

            root = mapper.readValue(err1, Root.class);

            root.setResponseTimestamp(Utils.getCurrentTimestamp());
            httpStatusCode = HttpStatus.EXPECTATION_FAILED;

        } else {

            InputStream jsonSchemaStream = new ClassPathResource("SubASuccess.json").getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(jsonSchemaStream, baos);
            byte[] successBytes = baos.toByteArray();
            ByteArrayInputStream success = new ByteArrayInputStream(successBytes);

            success.reset();

            root = mapper.readValue(success, Root.class);

            root.setResponseTimestamp(Utils.getCurrentTimestamp());
            httpStatusCode = HttpStatus.ACCEPTED;

        }
        return new ResponseEntity<>(root, httpStatusCode);
    }
}
