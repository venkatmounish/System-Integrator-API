package com.gainwell.si.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gainwell.si.domain.ProviderInformation;
import com.gainwell.si.domain.Root;
import com.gainwell.si.domain.SubscriberA;
import com.gainwell.si.utils.ParseReqJson;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class DemoApplication {

    static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @SneakyThrows
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        /*
String schemaFile ="C:\\Users\\t158463\\Documents\\Gainwell\\SI\\providerJsonSchema.json";
        JsonNode jsonSchemaNode = null;
        try {
            jsonSchemaNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\providerJsonSchema.json"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(String.format("Unable to find the schema file at %s - %S", schemaFile, e.getMessage()));
        }


        // JsonNode jsonSchemaNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\workspace\\SI_Publish2PostGres\\src\\main\\resources\\ProviderManagementSchema-JSON - Copy.json"));

       //  JsonNode jsonSchemaNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\workspace" +
        //        "\\SI_Publish2PostGres\\src\\main\\resources\\ProviderManagementSchema.json"));

        // JsonNode jsonSchemaNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\workspace\\SI_Publish2PostGres\\src\\main\\resources\\SampleSchema"));

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.builder(JsonSchemaFactory.getInstance(SpecVersionDetector.detect(jsonSchemaNode))).objectMapper(mapper).build();

   //     JsonSchema schema = schemaFactory.getSchema(new FileInputStream("C:\\Users\\t158463\\Documents\\workspace" +
         //       "\\SI_Publish2PostGres\\src\\main\\resources\\ProviderManagementSchema-JSON - Copy.json"));

        JsonSchema schema = schemaFactory.getSchema(new FileInputStream("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\providerJsonSchema.json"));

        // JsonSchema schema = schemaFactory.getSchema(new FileInputStream("C:\\Users\\t158463\\Documents\\workspace\\SI_Publish2PostGres\\src\\main\\resources\\ProviderManagementSchema-JSON.json"));

        //  JsonSchema schema = schemaFactory.getSchema(new FileInputStream("C:\\Users\\t158463\\Documents\\workspace\\SI_Publish2PostGres\\src\\main\\resources\\SampleSchema"));

        //JsonNode jsonNode = mapper.readTree(new File
        ("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\Publisher-Request-Unsucessfull.json"));


         JsonNode jsonNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\Publisher-Request" +
                ".json"));

    //    Root root = mapper.treeToValue(jsonNode, Root.class);
        //root.getEnvelope().getBody().
        //   JsonNode jsonNode = mapper.readTree(new File("C:\\Users\\t158463\\Documents\\workspace\\SI_Publish2PostGres\\src\\main\\resources\\SampleJson"));


            Set<ValidationMessage> validationResult = schema.validate(jsonNode);
     //   schema.getParentSchema().getSchemaNode().get("1081");



        ErrorConstants ec = new ErrorConstants();
        //ec.getMIN_LENGTH_VIOLATION();

        if (validationResult.isEmpty()) {

            // show custom message if there is no validation error
            System.out.println("There is no validation errors");


        } else {

            // show all the validation error
            JsonNode finalJsonSchemaNode = jsonSchemaNode;
           // validationResult.forEach(vm -> System.out.println(vm.getMessage()  + vm.getClass() +"    ====   " + vm
            // .getPath().substring(1).replace(".","/") +finalJsonSchemaNode.at(vm.getPath().substring(1).replace(".","/"))));
            validationResult.forEach(vm -> {

                String errCode = vm.getCode();
                String path = vm.getPath().substring(1).replace(".","/");
                String msg = vm.getMessage();

              String errMsg = msg.substring(msg.lastIndexOf(".") + 1).replace(":","");

              System.out.println(errMsg + " ==== " + errCode + " ==== " + path);


            });

        }

//        File file = ResourceUtils.getFile("src/main/resources/providerJsonSchema.json");

  //      file.getPath();
    //    System.out.println("File Found : " + file.exists() +  "============="+file.getPath());


//       File file = ResourceUtils.getFile("classpath:providerJsonSchema.json");

   //     System.out.println(file.exists());






        File file = ResourceUtils.getFile("classpath:Publisher-Request.json");
        JsonNode jsonNode = mapper.readTree(file);

        JsonNode tmp = jsonNode.at("/Envelope/Body/CreateProvider/Payload/ProviderInformation");

        System.out.println("===========");
        System.out.println(tmp);
        System.out.println("===========");

        ParseReqJson parseReqJson = new ParseReqJson();
       // ProviderInformation providerInformation = mapper.treeToValue(tmp, ProviderInformation.class);

        String requestJson = new String(Files.readAllBytes(Paths.get("C:\\Users\\t158463\\Documents\\workspace\\System-Integrator-API\\src\\main\\resources\\Publisher-Request.json")));
        Root root = parseReqJson.parseJson(requestJson);
        ProviderInformation providerInformation = root.getCreateProvider().getPayload().getProviderInformation();
        System.out.println("===========");
        System.out.println(providerInformation.getProviderDemographics());
        System.out.println(providerInformation.getProviderAddress().getAddress().getAddressLine1());
        System.out.println("===========");

        SubscriberService subscriberService = new SubscriberService();
      //  CompletableFuture<SubscriberA> subA = subscriberService.genSubAMsg(providerInformation);
      //  System.out.println(subA);

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
       // System.out.println(mapper.writeValueAsString(subA.get()));
*/

        InputStream jsonSchemaStream = new ClassPathResource("SubAError_1.json").getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(jsonSchemaStream, baos);
        byte[] err1Bytes = baos.toByteArray();
       // ByteArrayInputStream err1 = new ByteArrayInputStream(err1Bytes);

      //  err1Bytes.reset();
        String s = new String(err1Bytes, StandardCharsets.UTF_8);
        System.out.println(s);

        System.out.println(s + "  ====== \n ========");


    }

}
