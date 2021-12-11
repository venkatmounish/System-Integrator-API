package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Certification{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("CertificateNumber")
    private String certificateNumber;
    @JsonProperty("CertificateType")
    private String certificateType;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvCrtfctnSrcKey")
    private String provCrtfctnSrcKey;
}
