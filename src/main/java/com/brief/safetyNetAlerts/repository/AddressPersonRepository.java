package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.model.AdressPerson;
import com.brief.safetyNetAlerts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressPersonRepository extends JpaRepository<AdressPerson, Long> {
    Optional<AdressPerson> findByPerson(Person person);
}
