package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.FireStations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireStationRepository extends JpaRepository<FireStations, Long> {
}
