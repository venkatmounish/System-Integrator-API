package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Contact{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ContactType")
    private String contactType;
    @JsonProperty("ContactDetail")
    private String contactDetail;
    @JsonProperty("ContactInstruction")
    private String contactInstruction;
    @JsonProperty("PreferredContactIndicator")
    private String preferredContactIndicator;
    @JsonProperty("ProvContactSrcKey")
    private String provContactSrcKey;
    @JsonProperty("SvcLctnCntctSrcKey")
    private String svcLctnCntctSrcKey;
}
