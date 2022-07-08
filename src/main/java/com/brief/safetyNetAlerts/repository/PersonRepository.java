package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);

//    Optional<Person> findByFUAndUsernameAndLastNameAndBirthday(String username, String lastName, String birthday);
    Optional<Person> findByUsername(String username);
    Optional<Person> findById(Long id);

    Boolean existsByEmail(String email);
}
