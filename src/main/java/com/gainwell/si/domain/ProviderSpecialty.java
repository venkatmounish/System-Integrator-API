package com.gainwell.si.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProviderSpecialty{
    @JsonProperty("Specialty")
    private Specialty specialty;
}
