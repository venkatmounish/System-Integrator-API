package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderOwnership{
    @JsonProperty("OwnershipDetails")
    public OwnershipDetails ownershipDetails;
    @JsonProperty("OwnerAddress")
    public OwnerAddress ownerAddress;
}
