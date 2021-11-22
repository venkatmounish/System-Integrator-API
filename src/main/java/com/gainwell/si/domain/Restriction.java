package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Restriction{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ReviewReason")
    public String reviewReason;
    @JsonProperty("ReviewType")
    public String reviewType;
    @JsonProperty("RestrictionClass")
    public String restrictionClass;
    @JsonProperty("ClaimType")
    public String claimType;
    @JsonProperty("IncludeExcludeIndicator")
    public String includeExcludeIndicator;
    @JsonProperty("LowCode")
    public String lowCode;
    @JsonProperty("HighCode")
    public String highCode;
    @JsonProperty("EffectiveDate")
    public Date effectiveDate;
    @JsonProperty("EndDate")
    public EndDate endDate;
    @JsonProperty("ProvRestrictionSrcKey")
    public String provRestrictionSrcKey;
}
