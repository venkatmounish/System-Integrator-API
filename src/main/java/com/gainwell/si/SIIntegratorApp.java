package com.gainwell.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gainwell.si"})
public class SIIntegratorApp {


    public static void main(String[] args) {

        SpringApplication.run(SIIntegratorApp.class, args);

    }
}
