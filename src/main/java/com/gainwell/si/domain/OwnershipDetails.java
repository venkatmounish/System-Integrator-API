package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnershipDetails{
    @JsonProperty("OwnerType")
    public String ownerType;
    @JsonProperty("OwnPercentage")
    public String ownPercentage;
    @JsonProperty("SanctionInd")
    public String sanctionInd;
    @JsonProperty("SanctionExplain")
    public String sanctionExplain;
    @JsonProperty("CriminalOffenseInd")
    public String criminalOffenseInd;
    @JsonProperty("CriminalOffenseExplain")
    public String criminalOffenseExplain;
    @JsonProperty("LicenseSuspendInd")
    public String licenseSuspendInd;
    @JsonProperty("LicenseSuspendExplain")
    public String licenseSuspendExplain;
    @JsonProperty("PenaltyInd")
    public String penaltyInd;
    @JsonProperty("PenaltyExplain")
    public String penaltyExplain;
    @JsonProperty("RecordStatusCode")
    public String recordStatusCode;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("OwnerIndividual")
    public OwnerIndividual ownerIndividual;
    @JsonProperty("ProvOwnrDtlSrcKey")
    public String provOwnrDtlSrcKey;
}

