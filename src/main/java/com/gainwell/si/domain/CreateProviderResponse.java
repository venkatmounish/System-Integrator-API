package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CreateProviderResponse {

    @JsonProperty("SITransactionKey")
    public String sITransactionKey;
    @JsonProperty("ModuleTransactionId")
    public String moduleTransactionId;
    @JsonProperty("ResponseCode")
    public String responseCode;
    @JsonProperty("ResponseType")
    public String responseType;
    @JsonProperty("ResponseMessage")
    public String responseMessage;
    @JsonProperty("ResponseDetails")
    public String responseDetails;

}
