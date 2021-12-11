package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Relationship{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("Owner1SSN")
    private String owner1SSN;
    @JsonProperty("Owner2OrgTaxIdNumber")
    private Owner2OrgTaxIdNumber owner2OrgTaxIdNumber;
    @JsonProperty("RelationType")
    private String relationType;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("OwnrRltnshpSrcKey")
    private String ownrRltnshpSrcKey;
}

