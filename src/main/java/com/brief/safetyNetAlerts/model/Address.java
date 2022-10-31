package com.brief.safetyNetAlerts.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String Zip;


//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "adresseId")
//    private Set<Person> personsSet = new HashSet<>();
}
