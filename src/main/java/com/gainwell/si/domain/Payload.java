package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload{
    @JsonProperty("ProviderInformation")
    public ProviderInformation providerInformation;
}
