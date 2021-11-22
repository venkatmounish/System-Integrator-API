package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ApplicationId")
    public String applicationId;
    @JsonProperty("ApplicationCreatedDate")
    public String applicationCreatedDate;
    @JsonProperty("ApprovalDate")
    public String approvalDate;
    @JsonProperty("StatePlanEnrollCode")
    public String statePlanEnrollCode;
    @JsonProperty("EnrollMethodCode")
    public String enrollMethodCode;
    @JsonProperty("ProvApplicationSrcKey")
    public String provApplicationSrcKey;
}
