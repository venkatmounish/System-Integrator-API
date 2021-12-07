package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(Include.NON_NULL)
public class SubscriberB {

    @JsonProperty("ProviderDemographics")
    private ProviderDemographics providerDemographics;

    @JsonProperty("ProviderAffiliations")
    private ProviderAffiliations providerAffiliations;

    @JsonProperty("ProviderServiceLocation")
    private ProviderServiceLocation providerServiceLocation;


}
