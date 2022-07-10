package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.MedicalRecordsDto;
import com.brief.safetyNetAlerts.model.Allergies;
import com.brief.safetyNetAlerts.model.MedicalRecords;
import com.brief.safetyNetAlerts.model.Medications;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.repository.AllergiesRepository;
import com.brief.safetyNetAlerts.repository.MedicalRecordsRepository;
import com.brief.safetyNetAlerts.repository.MedicationsRepository;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class MedicalRecordsServiceImpl {

    @Autowired
    private MedicalRecordsRepository medicalRecordsRepository;
    @Autowired
    private AllergiesRepository allergiesRepository;
    @Autowired
    private MedicationsRepository medicationsRepository;
    @Autowired
    private AllergiesServiceImpl allergiesService;
    @Autowired
    private MedicationServiceImpl medicationService;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private PersonRepository personRepository;


    public MedicalRecords saveMedicalRecords(MedicalRecords medicalRecords){
        MedicalRecords medicalRecord = medicalRecordsRepository.save(medicalRecords);
        return medicalRecord;
    }

    public MedicalRecords saveMedicalRecords1(MedicalRecords medicalRecords){
        List<Allergies> currentListAllergies = allergiesService.getAllAllergies();
        List<Medications> currentListMedications = medicationService.getAllMedications();
        Set<Allergies> allergies = medicalRecords.getAllergies();
        Set<Medications> medications = medicalRecords.getMedications();
        MedicalRecords medicalRecords1 = new MedicalRecords();

        allergies.forEach(allergie -> {
            String allergieName = allergie.getName();
            Optional<Allergies> allergies1 = allergiesRepository.findById(allergie.getId());
            Optional<Allergies> allergies2 = allergiesRepository.findByName(allergieName);

            if(currentListAllergies.contains(allergies1)){
                medicalRecords1.getAllergies().add(allergies1.get());
            }

        });

        medications.forEach(medication -> {
            String medicationName = medication.getName();
            Optional<Medications> medications1 = medicationsRepository.findById(medication.getId());
            Optional<Medications> medications2 = medicationsRepository.findByName(medicationName);

            if(currentListMedications.contains(medications1)){
                medicalRecords1.getMedications().add(medications1.get());
            }

        });

        medicalRecordsRepository.save(medicalRecords1);
        return medicalRecords1;
    }

    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordsRepository.findAll();
    }

    public Optional<MedicalRecords> getMedicalRecords(final Long id) {
        return medicalRecordsRepository.findById(id);
    }

    public MedicalRecords updateMedicalRecords(MedicalRecordsDto medicalRecordsDto){
        MedicalRecords medicalRecords = modelMapper.map(medicalRecordsDto, MedicalRecords.class);
        return medicalRecordsRepository.save(medicalRecords);
    }

    public MedicalRecords updateMedicalRecords1(MedicalRecords medicalRecords, Long id){
        MedicalRecords medicalRecords1 = medicalRecordsRepository.getById(id);
        medicalRecords1.setAllergies(medicalRecords.getAllergies());
        medicalRecords1.setMedications((medicalRecords.getMedications()));
        System.out.println(medicalRecords1);
        return medicalRecordsRepository.save(medicalRecords1);
    }

    public void deleteMedicalRecords(Long id){
        medicalRecordsRepository.deleteById(id);
    }
    //    supprimer un dossier médical (utilisez une combinaison de prénom et de nom comme
//            identificateur unique
    public void deleteMedicalRecordsByUsername(String username, String lastname){
        Person person = personRepository.findByUsernameAndLastName(username, lastname).get();
        System.out.println(person);
        MedicalRecords medicalRecords=person.getMedicalRecords();
        person.setMedicalRecords(null);
        personRepository.save(person);
        System.out.println(person);

        medicalRecordsRepository.delete(medicalRecords);

    }
}
