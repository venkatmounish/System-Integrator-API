package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Identifier{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("IdentifierTypeCode")
    private String identifierTypeCode;
    @JsonProperty("IssuingEntityID")
    private String issuingEntityID;
    @JsonProperty("IdentifierID")
    private String identifierID;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvIdentifierSrcKey")
    private String provIdentifierSrcKey;
}
