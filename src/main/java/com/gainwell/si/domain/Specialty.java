package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Specialty{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("SpecialtyCode")
    private String specialtyCode;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvSpcltySrcKey")
    private String provSpcltySrcKey;
}
