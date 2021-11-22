package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxonomyClassification{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("ClassificationTypeCode")
    public String classificationTypeCode;
    @JsonProperty("ClassificationCode")
    public String classificationCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ProvTxnmyClsfctnSrcKey")
    public String provTxnmyClsfctnSrcKey;
}
