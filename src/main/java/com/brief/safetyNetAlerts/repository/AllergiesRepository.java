package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Allergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergiesRepository extends JpaRepository<Allergies, Long> {
    Optional<Allergies> findByName(String name);
    Boolean existsByName(String name);

}
