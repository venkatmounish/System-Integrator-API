package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Affiliations{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ProviderId")
    private String providerId;
    @JsonProperty("NPI")
    private String nPI;
    @JsonProperty("ProviderAffiliationTypeCode")
    private String providerAffiliationTypeCode;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvAffiliationSrcKey")
    private String provAffiliationSrcKey;
}
