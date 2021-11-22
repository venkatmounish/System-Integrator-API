package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specialty{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("SpecialtyCode")
    public String specialtyCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvSpcltySrcKey")
    public String provSpcltySrcKey;
}
