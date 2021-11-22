package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Taxonomy{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("TaxonomyCode")
    public String taxonomyCode;
    @JsonProperty("PrimaryTaxonomyIndicator")
    public String primaryTaxonomyIndicator;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvTxnmySrcKey")
    public String provTxnmySrcKey;
}
