package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderBusinessStatus{
    @JsonProperty("BusinessStatus")
    public BusinessStatus businessStatus;
}
