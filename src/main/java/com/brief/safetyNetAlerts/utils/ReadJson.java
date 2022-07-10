//package com.brief.safetyNetAlerts.utils;
//
//import com.brief.safetyNetAlerts.Service.ServiceImpl.*;
//import com.brief.safetyNetAlerts.model.*;
//import com.brief.safetyNetAlerts.repository.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class ReadJson {
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Autowired
//private AddressRepository addressRepository;
//@Autowired
//private AllergiesRepository allergiesRepository;
//@Autowired
//private FireStationRepository fireStationRepository;
//@Autowired
//private MedicationsRepository medicationsRepository;
////    @Autowired
//private MedicationsRepository medicationsRepository1;
//@Autowired
//    PersonServiceImpl personnServiceImpl;
//@Autowired
//    AddressServiceImpl addressService;
//@Autowired
//    AllergiesServiceImpl allergiesService;
//@Autowired
//    FireStationServiceImpl fireStationService;
//@Autowired
//    MedicationServiceImpl medicationService;
//@Autowired
//    MedicalRecordsServiceImpl medicalRecordsService;
//@Autowired
//    PersonRepository personRepository;
//
//public  void readAndSaveJson() throws IOException {
//        JSONParser jsonParser = new JSONParser();
//        try {
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/data.json"));
//        JSONArray persons = (JSONArray) jsonObject.get("persons");
//        JSONArray firestations = (JSONArray) jsonObject.get("firestations");
//        JSONArray medicalrecords = (JSONArray) jsonObject.get("medicalrecords");
//
//        ArrayList<Object> listpersonn = new ArrayList<Object>();
//        ArrayList<Object> listfirestations = new ArrayList<Object>();
//        ArrayList<Object> listmedicalrecords = new ArrayList<Object>();
//
//        if (persons != null) {
//        for (int i = 0; i < persons.size(); i++) {
//        listpersonn.add(persons.get(i));
//        }
//        }
//
//        if (firestations != null) {
//        for (int i = 0; i < firestations.size(); i++) {
//        listfirestations.add(firestations.get(i));
//        }
//        }
//
//        if (medicalrecords != null) {
//        for (int i = 0; i < medicalrecords.size(); i++) {
//        listmedicalrecords.add(medicalrecords.get(i));
//        }
//        }
//
//        System.out.println("*******************************************************");
//        System.out.println("Each element of listpersonn");
//        for (int i = 0; i < listpersonn.size(); i++) {
//        JSONObject convertObjt = (JSONObject) listpersonn.get(i);
//
//        Address address = new Address();
//        String zip = (String) convertObjt.get("zip");
//        String addresse = (String) convertObjt.get("address");
//        String city = (String) convertObjt.get("city");
//        address.setZip(zip);
//        address.setAddress(addresse);
//        address.setCity(city);
//        addressService.saveAddressSimple(address);
//
//        String name = (String) convertObjt.get("firstName");
//        String lastname = (String) convertObjt.get("lastName");
//        String email = (String) convertObjt.get("email");
//        String phone = (String) convertObjt.get("phone");
//        Long addressId = address.getId();
//        Person newPerson = new Person();
//        newPerson.setFirstName(name);
//        newPerson.setLastName(lastname);
//        newPerson.setEmail(email);
//        newPerson.setPhone(phone);
//        newPerson.setAdresseId(addressId);
//        System.out.println("convertObjt  : " + convertObjt);
//        System.out.println("newPerson = " + newPerson);
//        personnServiceImpl.savePerson(newPerson);
//        }
//
//        System.out.println("*******************************************************");
//        System.out.println("Each element of listfirestations");
//        for (int i = 0; i < listfirestations.size(); i++) {
//        JSONObject convertObjt = (JSONObject) listfirestations.get(i);
//        FireStations fireStations = new FireStations();
//        String address = (String) convertObjt.get("email");
//        int station = (int) convertObjt.get("phone");
//        fireStations.setAddress(address);
//        fireStations.setStation(station);
//        fireStationService.addStation(fireStations);
//
//        System.out.println(convertObjt);
//        }
//
//        System.out.println("*******************************************************");
//        System.out.println("Each element of listmedicalrecords");
//        for (int i = 0; i < listmedicalrecords.size(); i++) {
//        JSONObject convertObjt = (JSONObject) listmedicalrecords.get(i);
////                allergies
//        JSONArray allergies = (JSONArray) convertObjt.get("allergies");
//        ArrayList<String> listAllergies = new ArrayList<String>();
//        Set<Allergies> listAllergiesZ = new HashSet<>();
//
//        if (allergies != null) {
//        allergies.forEach(allerg -> {
//        listAllergies.add((String) allerg);
//        });
//        }
//        for (int ind = 0; ind < listAllergies.size(); ind++){
//        String nameAllergie = listAllergies.get(ind);
//
//        Allergies allergie = new Allergies();
//        allergie.setName(nameAllergie);
//        allergiesService.saveAllergie(allergie);
//        listAllergiesZ.add(allergie);
//        }
//        //                medications
//        JSONArray medications = (JSONArray) convertObjt.get("medications");
//        ArrayList<String> listMedications = new ArrayList<String>();
//        Set<Medications> listMedicationZ = new HashSet<>();
//
//        if (medications != null) {
//        medications.forEach(allerg -> {
//        listMedications.add((String) allerg);
//        });
//        }
//        for (int ind = 0; ind < listMedications.size(); ind++){
//        String nameMedications = (String) listfirestations.get(ind);
//
//        Medications medication = new Medications();
//        medication.setName(nameMedications);
//        medicationService.saveMedicationSimple(medication);
//        listMedicationZ.add(medication);
//        }
//        //                medicalRecords
//        MedicalRecords medicalRecords = new MedicalRecords();
//        medicalRecords.setAllergies(listAllergiesZ);
//        medicalRecords.setMedications(listMedicationZ);
//        medicalRecordsService.saveMedicalRecords(medicalRecords);
//
//        String firstname = (String) convertObjt.get("firstName");
//        String lastname = (String) convertObjt.get("lastName");
//        String birthday = (String) convertObjt.get("birthdate");
//        Person person = personRepository.findByFirstNameAndLastNameAndBirthday(firstname, lastname, birthday).get();
//        person.setMedicalRecords(medicalRecords);
//        personRepository.save(person);
//
//        System.out.println(convertObjt);
//        System.out.println("person : " +person);
//        }
//
//        } catch (Exception ex) {
//        ex.printStackTrace();
//        }
//        }
//        }
