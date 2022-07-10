package com.brief.safetyNetAlerts.dto;

import com.brief.safetyNetAlerts.model.Allergies;
import com.brief.safetyNetAlerts.model.Medications;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MedicalRecordsDto {
    private  Long id;
    private Set<Medications> medicaments = new HashSet<>();
    private Set<Allergies> allergies = new HashSet<>();
}
