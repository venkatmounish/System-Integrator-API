package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ContactType")
    public String contactType;
    @JsonProperty("ContactDetail")
    public String contactDetail;
    @JsonProperty("ContactInstruction")
    public String contactInstruction;
    @JsonProperty("PreferredContactIndicator")
    public String preferredContactIndicator;
    @JsonProperty("ProvContactSrcKey")
    public String provContactSrcKey;
    @JsonProperty("SvcLctnCntctSrcKey")
    public String svcLctnCntctSrcKey;
}
