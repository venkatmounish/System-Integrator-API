package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Taxonomy{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("TaxonomyCode")
    private String taxonomyCode;
    @JsonProperty("PrimaryTaxonomyIndicator")
    private String primaryTaxonomyIndicator;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvTxnmySrcKey")
    private String provTxnmySrcKey;
}
