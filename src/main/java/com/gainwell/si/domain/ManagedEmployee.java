package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ManagedEmployee{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("ManageEmployeesType")
    private String manageEmployeesType;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    @JsonProperty("SSN")
    private String sSN;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvMngdEmplySrcKey")
    private String provMngdEmplySrcKey;
}
