package com.brief.safetyNetAlerts.dto;

import com.brief.safetyNetAlerts.model.MedicalRecords;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String email;
    private String phone;
    private String birthday;
    private Long adresseId;
    private String password;
    private MedicalRecords medicalRecords;

}
