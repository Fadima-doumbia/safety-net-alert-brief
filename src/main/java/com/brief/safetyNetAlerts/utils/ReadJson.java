package com.brief.safetyNetAlerts.utils;

import com.brief.safetyNetAlerts.Service.ServiceImpl.*;
import com.brief.safetyNetAlerts.model.*;
import com.brief.safetyNetAlerts.repository.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
@EnableScheduling
public class ReadJson {
        @Autowired
            PersonServiceImpl personnServiceImpl;
        @Autowired
            AddressServiceImpl addressService;
        @Autowired
            AllergiesServiceImpl allergiesService;
        @Autowired
            FireStationServiceImpl fireStationService;
        @Autowired
            MedicationServiceImpl medicationService;
        @Autowired
            MedicalRecordsServiceImpl medicalRecordsService;
        @Autowired
            PersonRepository personRepository;
        @Autowired
        AddressRepository addressRepository;
        @Autowired
        FireStationRepository fireStationRepository;
        @Autowired
        AddressPersonServiceImpl addressPersonService;
        @Autowired
        AllergiesRepository allergiesRepository;
        @Autowired
        MedicationsRepository medicationsRepository;

@Scheduled(fixedDelay = 100000)
public  void readAndSaveJson() throws IOException {
        JSONParser jsonParser = new JSONParser();
        try {
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/data.json"));
        JSONArray persons = (JSONArray) jsonObject.get("persons");
        JSONArray firestations = (JSONArray) jsonObject.get("firestations");
        JSONArray medicalrecords = (JSONArray) jsonObject.get("medicalrecords");

        ArrayList<Object> listpersonn = new ArrayList<Object>();
        ArrayList<Object> listfirestations = new ArrayList<Object>();
        ArrayList<Object> listmedicalrecords = new ArrayList<Object>();

        if (persons != null) {
        for (int i = 0; i < persons.size(); i++) {
        listpersonn.add(persons.get(i));
        }
        }

        if (firestations != null) {
        for (int i = 0; i < firestations.size(); i++) {
        listfirestations.add(firestations.get(i));
        }
        }

        if (medicalrecords != null) {
        for (int i = 0; i < medicalrecords.size(); i++) {
        listmedicalrecords.add(medicalrecords.get(i));
        }
        }

        System.out.println("*******************************************************");
        System.out.println("Each element of listpersonn");
        for (int i = 0; i < listpersonn.size(); i++) {
        JSONObject convertObjt = (JSONObject) listpersonn.get(i);
        String zip = (String) convertObjt.get("zip");
        String addresse = (String) convertObjt.get("address");
        String city = (String) convertObjt.get("city");
        Boolean ifAddressExist = addressRepository.existsByAddress(addresse);
        if (ifAddressExist){
           Address address = addressService.getAddress(addresse).get();
                String name = (String) convertObjt.get("firstName");
                String lastname = (String) convertObjt.get("lastName");
                String email = (String) convertObjt.get("email");
                String phone = (String) convertObjt.get("phone");
                Long addressId = address.getId();
                Person newPerson = new Person();
                newPerson.setUsername(name);
                newPerson.setLastName(lastname);
                newPerson.setEmail(email);
                newPerson.setPhone(phone);
                newPerson.setAdresseId(addressId);
                System.out.println("newPerson = " + newPerson);
                personnServiceImpl.savePersonSimple(newPerson);

        }else{
                Address address = new Address();
                address.setZip(zip);
                address.setAddress(addresse);
                address.setCity(city);
                addressService.saveAddressSimple(address);

                String name = (String) convertObjt.get("firstName");
                String lastname = (String) convertObjt.get("lastName");
                String email = (String) convertObjt.get("email");
                String phone = (String) convertObjt.get("phone");
                Long addressId = address.getId();
                Person newPerson = new Person();
                newPerson.setUsername(name);
                newPerson.setLastName(lastname);
                newPerson.setEmail(email);
                newPerson.setPhone(phone);
                newPerson.setAdresseId(addressId);
                personnServiceImpl.savePersonSimple(newPerson);
                System.out.println("newPerson = " + newPerson);
        }
        }

        System.out.println("*******************************************************");
        System.out.println("Each element of listfirestations");

        for (int i = 0; i < listfirestations.size(); i++) {
        JSONObject convertObjt = (JSONObject) listfirestations.get(i);
        FireStations fireStations = new FireStations();
                String addresse = (String) convertObjt.get("address");
//                int id = Integer.parseInt(jsonObj.get("id"));
                int stations = (int) Integer.parseInt((String) convertObjt.get("station"));

//                int stations = (Integer) convertObjt.get("station");
        fireStations.setAddress(addresse);
        fireStations.setStation(stations);
        fireStationRepository.save(fireStations);

        System.out.println(convertObjt);
        }

        System.out.println("*******************************************************");
        System.out.println("Each element of listmedicalrecords");
//        for (int i = 0; i < listmedicalrecords.size(); i++) {
//        JSONObject convertObjt = (JSONObject) listmedicalrecords.get(i);

                for (int i = 0; i < listmedicalrecords.size(); i++) {
                        JSONObject convertObjt = (JSONObject) listmedicalrecords.get(i);
//                allergies
        JSONArray allergies = (JSONArray) convertObjt.get("allergies");
        ArrayList<String> listAllergies = new ArrayList<String>();
        Set<Allergies> listAllergiesZ = new HashSet<>();
        if (allergies != null) {
        allergies.forEach(allerg -> {
        listAllergies.add((String) allerg);
        });
        }
        for (int ind = 0; ind < listAllergies.size(); ind++){
        String nameAllergie = listAllergies.get(ind);
                if (allergiesRepository.existsByName(nameAllergie)){
                        Optional<Allergies> allergies1 = allergiesRepository.findByName(nameAllergie);
                        listAllergiesZ.add(allergies1.get());
                }else{
                        Allergies allergie = new Allergies();
                        allergie.setName(nameAllergie);
                        allergiesService.saveAllergie(allergie);
                        listAllergiesZ.add(allergie);
                }
        }


        //                medications
        JSONArray medications = (JSONArray) convertObjt.get("medications");
        ArrayList<String> listMedications = new ArrayList<String>();
        Set<Medications> listMedicationZ = new HashSet<>();

        if (medications != null) {
        medications.forEach(allerg -> {
        listMedications.add((String) allerg);
        });
        }
                for (int ind = 0; ind < listMedications.size(); ind++){
                        String nameMedications = listMedications.get(ind);
                        if (medicationsRepository.existsByName(nameMedications)){
                                Optional<Medications> medications1 = medicationsRepository.findByName(nameMedications);
                                listmedicalrecords.add(medications1.get());
                        }else{
                                Medications medications1 = new Medications();
                                medications1.setName(nameMedications);
                                medicationsRepository.save(medications1);
                                listMedicationZ.add(medications1);
                        }
                }

//        for (int ind = 0; ind < listMedications.size(); ind++){
//                String nameMedications = (String) listfirestations.get(ind);
//        if (medicationsRepository.existsByName(nameMedications)){
//                Optional <Medications> medications1 = medicationsRepository.findByName(nameMedications);
//                listMedicationZ.add(medications1.get());
//        }else{
//                Medications medication = new Medications();
//                medication.setName(nameMedications);
//                medicationService.saveMedicationSimple(medication);
//                listMedicationZ.add(medication);
//        }
//
//        }


        //                medicalRecords
        MedicalRecords medicalRecords = new MedicalRecords();
        medicalRecords.setAllergies(listAllergiesZ);
        medicalRecords.setMedications(listMedicationZ);
        medicalRecordsService.saveMedicalRecords(medicalRecords);

        //person
        String firstname = (String) convertObjt.get("firstName");
        String lastname = (String) convertObjt.get("lastName");
        String birthday = (String) convertObjt.get("birthdate");
//                        System.out.println(convertObjt);
//        Optional<Person> person = personRepository.findByUsernameAndLastName(firstname, lastname);

        Optional<Person> person = personnServiceImpl.getPersonByName(firstname, lastname);
//                        System.out.println(person);
        person.get().setBirthday(birthday);
        person.get().setMedicalRecords(medicalRecords);
        personRepository.save(person.get());

//        System.out.println(convertObjt);
        System.out.println("person : " +person);
        }

        } catch (Exception ex) {
        ex.printStackTrace();
        }
        }
        }
