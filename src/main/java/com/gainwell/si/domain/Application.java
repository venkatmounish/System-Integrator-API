package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Application{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ApplicationId")
    private String applicationId;
    @JsonProperty("ApplicationCreatedDate")
    private String applicationCreatedDate;
    @JsonProperty("ApprovalDate")
    private String approvalDate;
    @JsonProperty("StatePlanEnrollCode")
    private String statePlanEnrollCode;
    @JsonProperty("EnrollMethodCode")
    private String enrollMethodCode;
    @JsonProperty("ProvApplicationSrcKey")
    private String provApplicationSrcKey;
}
