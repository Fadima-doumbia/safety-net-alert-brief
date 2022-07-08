package com.brief.safetyNetAlerts.dto;

import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String email;
    private String username;
    private String lastName;
    private String phone;
    private String birthday;
    private Long adresseId;
    private String password;
}
