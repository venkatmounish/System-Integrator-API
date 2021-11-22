package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderManagedEmployees{
    @JsonProperty("ManagedEmployee")
    public ManagedEmployee managedEmployee;
}

