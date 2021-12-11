package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BusinessStatus{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("BusinessStatusCode")
    private String businessStatusCode;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvBsnsStatusSrcKey")
    private String provBsnsStatusSrcKey;
}
