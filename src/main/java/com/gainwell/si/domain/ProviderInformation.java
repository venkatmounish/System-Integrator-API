package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderInformation{
    @JsonProperty("ProviderDemographics")
    public ProviderDemographics providerDemographics;
    @JsonProperty("ProviderAddress")
    public ProviderAddress providerAddress;
    @JsonProperty("ProviderContact")
    public ProviderContact providerContact;
    @JsonProperty("ProviderApplication")
    public ProviderApplication providerApplication;
    @JsonProperty("ProviderAlternateIdentifiers")
    public ProviderAlternateIdentifiers providerAlternateIdentifiers;
    @JsonProperty("ProviderType")
    public ProviderType providerType;
    @JsonProperty("ProviderAffiliations")
    public ProviderAffiliations providerAffiliations;
    @JsonProperty("ProviderOwnership")
    public ProviderOwnership providerOwnership;
    @JsonProperty("OwnerRelationship")
    public OwnerRelationship ownerRelationship;
    @JsonProperty("ProviderManagedEmployees")
    public ProviderManagedEmployees providerManagedEmployees;
    @JsonProperty("ProviderBusinessStatus")
    public ProviderBusinessStatus providerBusinessStatus;
    @JsonProperty("ProviderTaxonomyClassification")
    public ProviderTaxonomyClassification providerTaxonomyClassification;
    @JsonProperty("ProviderProgramAffiliations")
    public ProviderProgramAffiliations providerProgramAffiliations;
    @JsonProperty("ProviderEFTEnrollment")
    public ProviderEFTEnrollment providerEFTEnrollment;
    @JsonProperty("ProviderServiceLocation")
    public ProviderServiceLocation providerServiceLocation;
}
