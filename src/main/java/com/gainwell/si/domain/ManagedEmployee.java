package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagedEmployee{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("ManageEmployeesType")
    public String manageEmployeesType;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("SSN")
    public String sSN;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvMngdEmplySrcKey")
    public String provMngdEmplySrcKey;
}
