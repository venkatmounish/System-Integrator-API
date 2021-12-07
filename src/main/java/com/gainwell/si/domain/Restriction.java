package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Restriction{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ReviewReason")
    private String reviewReason;
    @JsonProperty("ReviewType")
    private String reviewType;
    @JsonProperty("RestrictionClass")
    private String restrictionClass;
    @JsonProperty("ClaimType")
    private String claimType;
    @JsonProperty("IncludeExcludeIndicator")
    private String includeExcludeIndicator;
    @JsonProperty("LowCode")
    private String lowCode;
    @JsonProperty("HighCode")
    private String highCode;
    @JsonProperty("EffectiveDate")
    private Date effectiveDate;
    @JsonProperty("EndDate")
    private EndDate endDate;
    @JsonProperty("ProvRestrictionSrcKey")
    private String provRestrictionSrcKey;
}
