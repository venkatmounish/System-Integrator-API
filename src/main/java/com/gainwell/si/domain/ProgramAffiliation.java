package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramAffiliation{
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("AffiliatedProgramCode")
    public String affiliatedProgramCode;
    @JsonProperty("API")
    public String aPI;
    @JsonProperty("AffiliatedProgramId")
    public String affiliatedProgramId;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("PgmAffltnSrcKey")
    public String pgmAffltnSrcKey;
}
