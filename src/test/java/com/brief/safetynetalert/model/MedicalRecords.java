package com.brief.safetynetalert.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "medicalRecords")
public class MedicalRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
  //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(    name = "md_medications",
            joinColumns = @JoinColumn(name = "medicalRecords_id"),
            inverseJoinColumns = @JoinColumn(name = "medications_id"))
    private Set<Medications> medications = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(    name = "md_allergies",
            joinColumns = @JoinColumn(name = "medicalRecords_id"),
            inverseJoinColumns = @JoinColumn(name = "allergies_id"))
    private Set<Allergies> allergies = new HashSet<>();

}
