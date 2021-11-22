package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderDemographics{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ProviderId")
    public String providerId;
    @JsonProperty("TaxId")
    public TaxId taxId;
    @JsonProperty("ProviderRoleCode")
    public String providerRoleCode;
    @JsonProperty("NationalProviderIdentifier")
    public String nationalProviderIdentifier;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("Prefix")
    public String prefix;
    @JsonProperty("Suffix")
    public String suffix;
    @JsonProperty("SSN")
    public String sSN;
    @JsonProperty("Gender")
    public String gender;
    @JsonProperty("EntityType")
    public String entityType;
    @JsonProperty("ProviderName")
    public String providerName;
    @JsonProperty("LegalProviderName")
    public String legalProviderName;
    @JsonProperty("ProviderBusinessName")
    public String providerBusinessName;
    @JsonProperty("ProviderTaxName")
    public String providerTaxName;
    @JsonProperty("TeachingIndicator")
    public String teachingIndicator;
    @JsonProperty("OwnershipCode")
    public String ownershipCode;
    @JsonProperty("ProviderProfitStatusCode")
    public String providerProfitStatusCode;
    @JsonProperty("NewPatientIndicator")
    public String newPatientIndicator;
    @JsonProperty("EnrollmentType")
    public String enrollmentType;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("DateOfDeath")
    public DateOfDeath dateOfDeath;
    @JsonProperty("ProvDemographicsSrcKey")
    public String provDemographicsSrcKey;
}
