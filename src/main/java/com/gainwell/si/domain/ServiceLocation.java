package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceLocation{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("LocationName")
    public String locationName;
    @JsonProperty("LocationCode")
    public String locationCode;
    @JsonProperty("OrgStateOwnedIndicator")
    public OrgStateOwnedIndicator orgStateOwnedIndicator;
    @JsonProperty("RAPrintIndicator")
    public RAPrintIndicator rAPrintIndicator;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ServiceLocationAddress")
    public ServiceLocationAddress serviceLocationAddress;
    @JsonProperty("ServiceLocationContact")
    public ServiceLocationContact serviceLocationContact;
    @JsonProperty("ProviderLicense")
    public ProviderLicense providerLicense;
    @JsonProperty("ProviderCertification")
    public ProviderCertification providerCertification;
    @JsonProperty("ProviderIdentifier")
    public ProviderIdentifier providerIdentifier;
    @JsonProperty("ProviderFacility")
    public ProviderFacility providerFacility;
    @JsonProperty("ProviderTaxonomy")
    public ProviderTaxonomy providerTaxonomy;
    @JsonProperty("ProviderSpecialty")
    public ProviderSpecialty providerSpecialty;
    @JsonProperty("ProviderType")
    public ProviderType providerType;
    @JsonProperty("ProviderRestriction")
    public ProviderRestriction providerRestriction;
    @JsonProperty("ProvSvcLocationSrcKey")
    public String provSvcLocationSrcKey;
}
