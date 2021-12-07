package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CreateProviderResponse {

    /*
    @JsonProperty("SITransactionKey")
    private String sITransactionKey;
    @JsonProperty("ModuleTransactionId")
    @JsonProperty("ResponseType")
    private String responseType;
    */

    // private String moduleTransactionId;

    @JsonProperty("SequenceNumber")
    private long sequenceNumber;
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseMessage")
    private String responseMessage;
    @JsonProperty("ResponseDetails")
    private String responseDetails;



}
