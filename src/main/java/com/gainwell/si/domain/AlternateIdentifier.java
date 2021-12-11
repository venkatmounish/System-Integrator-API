package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AlternateIdentifier{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("AlternateIdType")
    public String alternateIdType;
    @JsonProperty("AlternateId")
    public String alternateId;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvAlternateIdSrcKey")
    public String provAlternateIdSrcKey;
}
