package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.gainwell.si.utils.Utils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Component
public class Root{

/*    @JsonProperty("Envelope")
    private Envelope envelope;

    @JsonProperty("Header")
    private Header header;*/

    @JsonProperty("CreateProvider")
    private CreateProvider createProvider;

    @JsonProperty("SITransactionKey")
    private String sITransactionKey;
    @JsonProperty("ModuleTransactionId")
    private String moduleTransactionId;
    @JsonProperty("TargetSystem")
    private String targetSystem;
    @JsonProperty("ResponseType")
    private String responseType;
    @JsonProperty("ResponseTimestamp")
    private LocalDateTime responseTimestamp;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("FailedValidations")
    private long failedValidations;

    @JsonProperty("ResponseError")
    private List<CreateProviderResponse> createProviderResponse;

    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseMessage")
    private String responseMessage;

}

