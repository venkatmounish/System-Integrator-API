package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessStatus{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("BusinessStatusCode")
    public String businessStatusCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvBsnsStatusSrcKey")
    public String provBsnsStatusSrcKey;
}
