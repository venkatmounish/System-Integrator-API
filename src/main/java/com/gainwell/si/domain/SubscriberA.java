package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNullFields;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(Include.NON_NULL)
public class SubscriberA {

    @JsonProperty("ProviderDemographics")
    private ProviderDemographics providerDemographics;
    @JsonProperty(value = "ProviderAddress")
    private ProviderAddress providerAddress;
    @JsonProperty("ProviderContact")
    private ProviderContact providerContact;
    @JsonProperty("ProviderApplication")
    private ProviderApplication providerApplication;
    @JsonProperty("ProviderType")
    private ProviderType providerType;
    @JsonProperty("ProviderAffiliations")
    private ProviderAffiliations providerAffiliations;
    @JsonProperty("ProviderServiceLocation")
    private ProviderServiceLocation providerServiceLocation;

/*    @JsonProperty(value = "ProviderServiceLocationffff" , required = true)
    private String providerServiceLocationffff;
    @JsonCreator
    public SubscriberA(@JsonProperty(value = "providerAddress", required = true) ProviderAddress providerAddress){

        this.providerAddress = providerAddress;
    }*/
   /* @JsonProperty("ServiceLocationAddress")
    private ServiceLocationAddress serviceLocationAddress;
    @JsonProperty("ServiceLocationContact")
    private ServiceLocationContact serviceLocationContact;
    @JsonProperty("ProviderLicense")
    private ProviderLicense providerLicense;
    @JsonProperty("License")
    private License license;
    @JsonProperty("ProviderCertification")
    private ProviderCertification providerCertifications;
    @JsonProperty("ProviderIdentifier")
    private ProviderIdentifier providerIdentifier;
    @JsonProperty("ProviderFacility")
    private ProviderFacility providerFacility;
    @JsonProperty("ProviderTaxonomy")
    private ProviderTaxonomy providerTaxonomy;
    @JsonProperty("ProviderSpecialty")
    private ProviderSpecialty providerSpecialty;
    @JsonProperty("ProviderType")
    private ProviderType providerType2;*/

}
