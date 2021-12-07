package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EFTEnrollment{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("EFTEnrollmentId")
    private String eFTEnrollmentId;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private EndDate endDate;
    @JsonProperty("FinancialInstitutionAccountNumber")
    private String financialInstitutionAccountNumber;
    @JsonProperty("FinancialInstitutionAccountType")
    private String financialInstitutionAccountType;
    @JsonProperty("FinancialInstitutionName")
    private String financialInstitutionName;
    @JsonProperty("FinancialInstitutionRoutingNumber")
    private String financialInstitutionRoutingNumber;
    @JsonProperty("ProviderContactFirstName")
    private String providerContactFirstName;
    @JsonProperty("ProviderContactLastName")
    private String providerContactLastName;
    @JsonProperty("ProviderContactMiddleName")
    private String providerContactMiddleName;
    @JsonProperty("ProviderContactPhoneNumber")
    private String providerContactPhoneNumber;
    @JsonProperty("ProviderContactPhoneNumberExtension")
    private String providerContactPhoneNumberExtension;
    @JsonProperty("ProviderContactTitle")
    private String providerContactTitle;
    @JsonProperty("EFTStatus")
    private String eFTStatus;
    @JsonProperty("ProvEFTEnrollmentSrcKey")
    private String provEFTEnrollmentSrcKey;
}
