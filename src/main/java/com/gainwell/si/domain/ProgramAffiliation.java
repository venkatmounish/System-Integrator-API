package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProgramAffiliation{
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("AffiliatedProgramCode")
    private String affiliatedProgramCode;
    @JsonProperty("API")
    private String aPI;
    @JsonProperty("AffiliatedProgramId")
    private String affiliatedProgramId;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("PgmAffltnSrcKey")
    private String pgmAffltnSrcKey;
}
