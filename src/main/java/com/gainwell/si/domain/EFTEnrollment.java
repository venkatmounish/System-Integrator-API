package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EFTEnrollment{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("EFTEnrollmentId")
    public String eFTEnrollmentId;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public EndDate endDate;
    @JsonProperty("FinancialInstitutionAccountNumber")
    public String financialInstitutionAccountNumber;
    @JsonProperty("FinancialInstitutionAccountType")
    public String financialInstitutionAccountType;
    @JsonProperty("FinancialInstitutionName")
    public String financialInstitutionName;
    @JsonProperty("FinancialInstitutionRoutingNumber")
    public String financialInstitutionRoutingNumber;
    @JsonProperty("ProviderContactFirstName")
    public String providerContactFirstName;
    @JsonProperty("ProviderContactLastName")
    public String providerContactLastName;
    @JsonProperty("ProviderContactMiddleName")
    public String providerContactMiddleName;
    @JsonProperty("ProviderContactPhoneNumber")
    public String providerContactPhoneNumber;
    @JsonProperty("ProviderContactPhoneNumberExtension")
    public String providerContactPhoneNumberExtension;
    @JsonProperty("ProviderContactTitle")
    public String providerContactTitle;
    @JsonProperty("EFTStatus")
    public String eFTStatus;
    @JsonProperty("ProvEFTEnrollmentSrcKey")
    public String provEFTEnrollmentSrcKey;
}
