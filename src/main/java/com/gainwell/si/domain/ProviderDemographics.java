package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(Include.NON_NULL)
public class ProviderDemographics{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ProviderId")
    private String providerId;
    @JsonProperty("TaxId")
    private TaxId taxId;
    @JsonProperty("ProviderRoleCode")
    private String providerRoleCode;
    @JsonProperty("NationalProviderIdentifier")
    private String nationalProviderIdentifier;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Prefix")
    private String prefix;
    @JsonProperty("Suffix")
    private String suffix;
    @JsonProperty("SSN")
    private String sSN;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("EntityType")
    private String entityType;
    @JsonProperty("ProviderName")
    private String providerName;
    @JsonProperty("LegalProviderName")
    private String legalProviderName;
    @JsonProperty("ProviderBusinessName")
    private String providerBusinessName;
    @JsonProperty("ProviderTaxName")
    private String providerTaxName;
    @JsonProperty("TeachingIndicator")
    private String teachingIndicator;
    @JsonProperty("OwnershipCode")
    private String ownershipCode;
    @JsonProperty("ProviderProfitStatusCode")
    private String providerProfitStatusCode;
    @JsonProperty("NewPatientIndicator")
    private String newPatientIndicator;
    @JsonProperty("EnrollmentType")
    private String enrollmentType;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    @JsonProperty("DateOfDeath")
    private DateOfDeath dateOfDeath;
    @JsonProperty("ProvDemographicsSrcKey")
    private String provDemographicsSrcKey;
}
