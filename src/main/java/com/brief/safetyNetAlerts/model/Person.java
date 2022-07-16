package com.brief.safetyNetAlerts.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String lastName;
    private String phone;
    private String birthday;
    private Long adresseId;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable=false)
    private Role role;
    @OneToOne(fetch=FetchType.EAGER)
    private MedicalRecords medicalRecords;
//    @OneToOne(fetch= FetchType.EAGER)
//    private Address address;
    
    public Person(String email, String username, String lastName, String phone, String birthday, Long adresseId, String encode) {
        this.email=email;
        this.username=username;
        this.lastName=lastName;
        this.phone=phone;
        this.birthday=birthday;
        this.adresseId=adresseId;
        this.password=encode;
    }

    public Person(String username, String lastName, String email, String encode) {
        this.email=email;
        this.username=username;
        this.lastName=lastName;
        this.password=encode;
    }
}
