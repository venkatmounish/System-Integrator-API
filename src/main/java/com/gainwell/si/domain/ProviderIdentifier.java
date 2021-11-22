package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderIdentifier{
    @JsonProperty("Identifier")
    public Identifier identifier;
}
