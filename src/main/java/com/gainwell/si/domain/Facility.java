package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Facility{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("BedTypeCode")
    public String bedTypeCode;
    @JsonProperty("BedCount")
    public String bedCount;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvFacilitySrcKey")
    public String provFacilitySrcKey;
}

