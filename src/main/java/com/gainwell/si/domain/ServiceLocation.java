package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ServiceLocation{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("LocationName")
    private String locationName;
    @JsonProperty("LocationCode")
    private String locationCode;
    @JsonProperty("OrgStateOwnedIndicator")
    private String orgStateOwnedIndicator;
    @JsonProperty("RAPrintIndicator")
    private String rAPrintIndicator;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("ServiceLocationAddress")
    private ServiceLocationAddress serviceLocationAddress;
    @JsonProperty("ServiceLocationContact")
    private ServiceLocationContact serviceLocationContact;
    @JsonProperty("ProviderLicense")
    private ProviderLicense providerLicense;
    @JsonProperty("ProviderCertification")
    private ProviderCertification providerCertification;
    @JsonProperty("ProviderIdentifier")
    private ProviderIdentifier providerIdentifier;
    @JsonProperty("ProviderFacility")
    private ProviderFacility providerFacility;
    @JsonProperty("ProviderTaxonomy")
    private ProviderTaxonomy providerTaxonomy;
    @JsonProperty("ProviderSpecialty")
    private ProviderSpecialty providerSpecialty;
    @JsonProperty("ProviderType")
    private ProviderType providerType;
    @JsonProperty("ProviderRestriction")
    private ProviderRestriction providerRestriction;
    @JsonProperty("ProvSvcLocationSrcKey")
    private String provSvcLocationSrcKey;
}
