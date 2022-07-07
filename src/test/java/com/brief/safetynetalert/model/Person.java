package com.brief.safetynetalert.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "person", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email") })
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String lastName;
    private String phone;
    private String phone2;
    private String birthday;
    private Long adresseId;
    private String password;
    @OneToOne(fetch=FetchType.EAGER)
    private MedicalRecords medicalRecords;
    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(	name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Person(String email, String username, String lastName, String phone, String birthday, Long adresseId, String encode) {
        this.email=email;
        this.username=username;
        this.lastName=lastName;
        this.phone=phone;
        this.birthday=birthday;
        this.adresseId=adresseId;
        this.password=encode;
    }
}
