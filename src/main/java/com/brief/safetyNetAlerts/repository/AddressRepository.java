package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByAddress (String address);
    Boolean existsByAddress(String address);

}
