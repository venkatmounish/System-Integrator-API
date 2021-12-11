package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Address{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("AddressType")
    private String addressType;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("CountyCode")
    private String countyCode;
    @JsonProperty("ZipCode5")
    private String zipCode5;
    @JsonProperty("ZipCode4")
    private String zipCode4;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("BorderStateIndicator")
    private String borderStateIndicator;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvAddressSrcKey")
    private String provAddressSrcKey;
    @JsonProperty("ProvOwnrAdrsSrcKey")
    private String provOwnrAdrsSrcKey;
    @JsonProperty("Latitude")
    private String latitude;
    @JsonProperty("Longitude")
    private String longitude;
    @JsonProperty("SvcLctnAdrsSrcKey")
    private String svcLctnAdrsSrcKey;
}
