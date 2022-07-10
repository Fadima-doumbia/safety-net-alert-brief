package com.brief.safetyNetAlerts.dto;

import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.model.Person;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class AddressPersonDto {
    private  Long id;
    private Person person;
    private Address address;
}
