package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationship{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("Owner1SSN")
    public String owner1SSN;
    @JsonProperty("Owner2OrgTaxIdNumber")
    public Owner2OrgTaxIdNumber owner2OrgTaxIdNumber;
    @JsonProperty("RelationType")
    public String relationType;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("OwnrRltnshpSrcKey")
    public String ownrRltnshpSrcKey;
}

