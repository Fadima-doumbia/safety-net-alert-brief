package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
