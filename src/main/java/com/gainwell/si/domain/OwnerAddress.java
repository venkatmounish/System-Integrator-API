package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerAddress{
    @JsonProperty("Address")
    public Address address;
}
