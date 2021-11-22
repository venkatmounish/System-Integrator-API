package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("AddressType")
    public String addressType;
    @JsonProperty("AddressLine1")
    public String addressLine1;
    @JsonProperty("AddressLine2")
    public String addressLine2;
    @JsonProperty("City")
    public String city;
    @JsonProperty("State")
    public String state;
    @JsonProperty("CountyCode")
    public String countyCode;
    @JsonProperty("ZipCode5")
    public String zipCode5;
    @JsonProperty("ZipCode4")
    public String zipCode4;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("BorderStateIndicator")
    public String borderStateIndicator;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvAddressSrcKey")
    public String provAddressSrcKey;
    @JsonProperty("ProvOwnrAdrsSrcKey")
    public String provOwnrAdrsSrcKey;
    @JsonProperty("Latitude")
    public String latitude;
    @JsonProperty("Longitude")
    public String longitude;
    @JsonProperty("SvcLctnAdrsSrcKey")
    public String svcLctnAdrsSrcKey;
}
