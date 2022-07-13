package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.PersonDto;
import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.model.AdressPerson;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.repository.AddressPersonRepository;
import com.brief.safetyNetAlerts.repository.AddressRepository;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressPersonServiceImpl addressPersonService;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private AddressPersonRepository addressPersonRepository;
    @Autowired
    private MedicalRecordsServiceImpl medicalRecordsService;


    public Person savePerson(Person person){
    return personRepository.save(person);
}

    public Person savePersonSimple(Person person){
        if(Objects.isNull(person.getMedicalRecords()) ){
            System.out.println("null");
        }else {
            medicalRecordsService.saveMedicalRecords(person.getMedicalRecords());
        }
        System.out.println(person);
        Person person1 = personRepository.save(person);
        Address address = addressRepository.findById(person1.getAdresseId()).get();
        AdressPerson adressPerson = new AdressPerson();
        adressPerson.setPerson(person1);
        adressPerson.setAddress(address);
        addressPersonService.saveAddressPerson( adressPerson );
        return person1;
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(final Long id) {
        return personRepository.findById(id);
    }

    public Optional<Person> getPersonByName( String firstname, String lastname) {
        return personRepository.findByUsernameAndLastName(firstname, lastname);
    }


    public Person updatePerson(PersonDto personDto){
        Person person = modelMapper.map(personDto, Person.class);
        return personRepository.save(person);
    }

    public void adminDeletePerson(Long id){
        personRepository.deleteById(id);
    }
    public String adminDelete(String username, String lastname){
        Person person = personRepository.findByUsername(username).get();
        System.out.println(person);
        AdressPerson adressPerson = addressPersonRepository.findByPerson(person).get();
        addressPersonRepository.delete(adressPerson);
        personRepository.delete(person);
//        System.out.println(person);
        return "ok";

//        personRepository.deletePersonByUsernameAndLastName(username, lastname);
    }

}
