package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ProviderTypeCode")
    public String providerTypeCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvTypeSrcKey")
    public String provTypeSrcKey;
}

