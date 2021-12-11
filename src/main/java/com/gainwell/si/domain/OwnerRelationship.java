package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OwnerRelationship{
    @JsonProperty("Relationship")
    private Relationship relationship;
}

