package com.brief.safetyNetAlerts.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "address", uniqueConstraints = {
        @UniqueConstraint(columnNames = "address") })
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
