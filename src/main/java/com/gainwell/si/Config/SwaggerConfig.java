package com.gainwell.si.Config;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableSwagger2
@Component
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

/*
        RequestParameterBuilder tokenBuilder = new RequestParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
*/




        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gainwell.si.controller"))
                .paths(regex("/api/.*"))
                                .build()
                .apiInfo(apiInfo());
               // .globalRequestParameters();

    }


    public ApiInfo apiInfo() {
        return new ApiInfo(
                "Sytem Integration API",
                "Adding Provider info",
                "v1",
                "Terms of service",
                new Contact("Gainwell Technologies", "www.gainwelltechnologies.com", "support@gainwelltechnologies" +
                        ".com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
