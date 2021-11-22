package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identifier{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("IdentifierTypeCode")
    public String identifierTypeCode;
    @JsonProperty("IssuingEntityID")
    public String issuingEntityID;
    @JsonProperty("IdentifierID")
    public String identifierID;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvIdentifierSrcKey")
    public String provIdentifierSrcKey;
}
