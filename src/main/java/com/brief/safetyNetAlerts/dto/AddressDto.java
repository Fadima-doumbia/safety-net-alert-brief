package com.brief.safetyNetAlerts.dto;

import com.brief.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AddressDto {
    private Long id;
    private String address;
    private String city;
    private String Zip;
//    private Set<Person> personsSet = new HashSet<>();
}
