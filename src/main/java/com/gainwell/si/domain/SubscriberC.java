package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriberC {

    @JsonProperty("ProviderDemographics")
    private ProviderDemographics providerDemographics;
    @JsonProperty(value = "ProviderAddress")
    private ProviderAddress providerAddress;
    @JsonProperty("ProviderContact")
    private ProviderContact providerContact;
    @JsonProperty("ProviderApplication")
    private ProviderApplication providerApplication;
    @JsonProperty("ProviderAlternateIdentifiers")
    private ProviderAlternateIdentifiers providerAlternateIdentifiers;
    @JsonProperty("ProviderType")
    private ProviderType providerType;
    @JsonProperty("ProviderAffiliations")
    private ProviderAffiliations providerAffiliations;
    @JsonProperty("ProviderOwnership")
    private ProviderOwnership providerOwnership;
    @JsonProperty("OwnerRelationship")
    private OwnerRelationship ownerRelationship;
    @JsonProperty("ProviderManagedEmployees")
    private ProviderManagedEmployees providerManagedEmployees;
    @JsonProperty("ProviderBusinessStatus")
    private ProviderBusinessStatus providerBusinessStatus;
    @JsonProperty("ProviderTaxonomyClassification")
    private ProviderTaxonomyClassification providerTaxonomyClassification;
    @JsonProperty("ProviderProgramAffiliations")
    private ProviderProgramAffiliations providerProgramAffiliations;
    @JsonProperty("ProviderEFTEnrollment")
    private ProviderEFTEnrollment providerEFTEnrollment;
    @JsonProperty("ProviderServiceLocation")
    private ProviderServiceLocation providerServiceLocation;

}
