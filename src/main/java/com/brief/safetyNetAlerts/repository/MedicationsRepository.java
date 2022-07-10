package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationsRepository extends JpaRepository<Medications, Long> {
    Optional<Medications> findByName(String name);

}
