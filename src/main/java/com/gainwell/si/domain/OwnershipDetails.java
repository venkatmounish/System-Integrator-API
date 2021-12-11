package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OwnershipDetails{
    @JsonProperty("OwnerType")
    private String ownerType;
    @JsonProperty("OwnPercentage")
    private String ownPercentage;
    @JsonProperty("SanctionInd")
    private String sanctionInd;
    @JsonProperty("SanctionExplain")
    private String sanctionExplain;
    @JsonProperty("CriminalOffenseInd")
    private String criminalOffenseInd;
    @JsonProperty("CriminalOffenseExplain")
    private String criminalOffenseExplain;
    @JsonProperty("LicenseSuspendInd")
    private String licenseSuspendInd;
    @JsonProperty("LicenseSuspendExplain")
    private String licenseSuspendExplain;
    @JsonProperty("PenaltyInd")
    private String penaltyInd;
    @JsonProperty("PenaltyExplain")
    private String penaltyExplain;
    @JsonProperty("RecordStatusCode")
    private String recordStatusCode;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("OwnerIndividual")
    private OwnerIndividual ownerIndividual;
    @JsonProperty("ProvOwnrDtlSrcKey")
    private String provOwnrDtlSrcKey;
}

