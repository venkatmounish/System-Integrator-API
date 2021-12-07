package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaxonomyClassification{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("ClassificationTypeCode")
    private String classificationTypeCode;
    @JsonProperty("ClassificationCode")
    private String classificationCode;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ProvTxnmyClsfctnSrcKey")
    private String provTxnmyClsfctnSrcKey;
}
