package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);

    String deletePersonByUsernameAndLastName(String username, String lastname);
    Optional<Person> findByUsernameAndLastNameAndBirthday(String username, String lastName, String birthday);
    Optional<Person> findByUsername(String username);
    Optional<Person> findById(Long id);
    Optional<Person> findByUsernameAndLastName(String username, String lastname);

    Boolean existsByEmail(String email);
}
