package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class MessageHeader{
    @JsonProperty("BusinessFlow")
    private String businessFlow;
    @JsonProperty("StateCode")
    private String stateCode;
    @JsonProperty("RequestorSystem")
    private String requestorSystem;
    @JsonProperty("ModuleTransactionId")
    private String moduleTransactionId;
    @JsonProperty("RequestTimestamp")
    private Date requestTimestamp;
    @JsonProperty("SITransactionKey")
    private String sITransactionKey;
}
