package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class License{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("LicenseType")
    private String licenseType;
    @JsonProperty("LicenseNumber")
    private String licenseNumber;
    @JsonProperty("LicenseeStateCode")
    private String licenseeStateCode;
    @JsonProperty("LicenseIssueBoardNotes")
    private String licenseIssueBoardNotes;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("StatusReason")
    private String statusReason;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvLicenseSrcKey")
    private String provLicenseSrcKey;
}
