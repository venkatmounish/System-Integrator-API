package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Certification{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("CertificateNumber")
    public String certificateNumber;
    @JsonProperty("CertificateType")
    public String certificateType;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvCrtfctnSrcKey")
    public String provCrtfctnSrcKey;
}
