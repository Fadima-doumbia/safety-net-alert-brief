package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.MedicalRecords;
import com.brief.safetyNetAlerts.model.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Long> {
}
