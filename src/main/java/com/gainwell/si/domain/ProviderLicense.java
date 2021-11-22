package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderLicense{
    @JsonProperty("License")
    public License license;
}
