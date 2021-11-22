package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerIndividual{
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("SSN")
    public String sSN;
    @JsonProperty("OwnerIndvSrcKey")
    public String ownerIndvSrcKey;
}
