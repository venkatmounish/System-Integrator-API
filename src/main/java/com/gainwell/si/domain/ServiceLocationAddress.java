package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceLocationAddress{
    @JsonProperty("Address")
    public Address address;
}
