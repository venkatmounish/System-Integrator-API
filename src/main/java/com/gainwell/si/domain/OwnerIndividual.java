package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OwnerIndividual{
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    @JsonProperty("SSN")
    private String sSN;
    @JsonProperty("OwnerIndvSrcKey")
    private String ownerIndvSrcKey;
}
