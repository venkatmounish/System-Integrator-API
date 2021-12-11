package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Facility{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("BedTypeCode")
    private String bedTypeCode;
    @JsonProperty("BedCount")
    private String bedCount;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvFacilitySrcKey")
    private String provFacilitySrcKey;
}

