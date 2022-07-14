package com.brief.safetyNetAlerts.dto;

import lombok.Data;

@Data
public class AllergiesDto {
    private  Long id;
    private String name;
    private Long medicalRecordId;
}
