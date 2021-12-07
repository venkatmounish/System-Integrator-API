package com.gainwell.si.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Utils {

/*    public static Timestamp getCurrentTimestamp() {

        return new Timestamp(System.currentTimeMillis());
    }*/

    public static LocalDateTime getCurrentTimestamp() {

        LocalDateTime now = LocalDateTime.now();
        return now;
    }

    public static UUID getUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public static void saveAsFile(Object object) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // mapper.writeValueAsString(object);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            /*mapper.writeValue(new File("C:\\Users\\t158463\\Documents\\workspace\\System-Integrator-API\\src\\main" +
                    "\\resources\\" + object.getClass().getSimpleName() + "_" + genRandomNum()), object);*/

            String subName = object.getClass().getSimpleName();
            String subFileName = "subscribers/" + subName + "/" + subName + "_" + genRandomNum() + ".json";

            File subFile = new File(subFileName);
            subFile.getParentFile().mkdirs();
            mapper.writerWithDefaultPrettyPrinter().writeValue(subFile, object);

        } catch (JsonProcessingException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
            // TODO: ADD LOGGING
        }

    }

    public static int genRandomNum() {

        int int_random = Math.abs(ThreadLocalRandom.current().nextInt());

        return int_random;
    }

    /*    public static String getCurrentTimestamp(){

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            return dtf.format(now);
        }*/
    public static void main(String[] args) {


        System.out.println(getUUID());
        System.out.println(getCurrentTimestamp());


    }

}
