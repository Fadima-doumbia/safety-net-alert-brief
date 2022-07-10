package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.model.AdressPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressPersonRepository extends JpaRepository<AdressPerson, Long> {

}
