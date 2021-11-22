package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class License{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("LicenseType")
    public String licenseType;
    @JsonProperty("LicenseNumber")
    public String licenseNumber;
    @JsonProperty("LicenseeStateCode")
    public String licenseeStateCode;
    @JsonProperty("LicenseIssueBoardNotes")
    public String licenseIssueBoardNotes;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("StatusReason")
    public String statusReason;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvLicenseSrcKey")
    public String provLicenseSrcKey;
}
