package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Affiliations{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ProviderId")
    public String providerId;
    @JsonProperty("NPI")
    public String nPI;
    @JsonProperty("ProviderAffiliationTypeCode")
    public String providerAffiliationTypeCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvAffiliationSrcKey")
    public String provAffiliationSrcKey;
}
