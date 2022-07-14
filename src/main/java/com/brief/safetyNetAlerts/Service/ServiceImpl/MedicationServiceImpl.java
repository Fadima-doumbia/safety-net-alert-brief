package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.MedicationDto;
import com.brief.safetyNetAlerts.model.Medications;
import com.brief.safetyNetAlerts.repository.MedicationsRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class MedicationServiceImpl {
    @Autowired
    private MedicationsRepository medicationsRepository;
//    @Autowired
//    private MedicalRecordsRepository medicalRecordsRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Medications createNewMedication(Medications medications, String email){
        Medications medications1 = medicationsRepository.save(medications);
        return medications1;
    }

    public Medications saveMedicationSimple(Medications medications){
        Medications medication = medicationsRepository.save(medications);
        return medication;
    }

    public List<Medications> getAllMedications() {
        return medicationsRepository.findAll();
    }

    public Optional<Medications> getMedicationsByName(String name) {
        return medicationsRepository.findByName(name);
    }

    public Optional<Medications> getMedication(final Long id) {
        return medicationsRepository.findById(id);
    }

    public Medications updateMedication(MedicationDto medicationsDto){
        Medications medication = modelMapper.map(medicationsDto, Medications.class);
        return medicationsRepository.save(medication);
    }

    public void adminDeleteMedication(Long id){
        medicationsRepository.deleteById(id);
    }

}