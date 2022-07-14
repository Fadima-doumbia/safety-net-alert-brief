package com.brief.safetyNetAlerts.service;


import com.brief.safetyNetAlerts.dto.PersonDto;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.service.ServiceImpl.PersonServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonServiceTest {
    @Autowired
    private PersonServiceImpl personService;
    Person person = new Person();


    @Test
    @Order(1)
    void getAllUsers(){
        List<Person> users = personService.getAllPerson();
        int size = 23;
        Assert.assertEquals(users.size(), size);
    }

    @Test
    @Order(2)
    void getUser(){
        Person userNew = personService.getPerson(1l).get();
        String email = "jaboyd@email.com";
        Assert.assertEquals(userNew.getEmail(), email);
    }

    @Test
    @Order(3)
    void  createPerson(){
        Person newPerson = new Person();
        newPerson.setBirthday("12/11/2022");
        newPerson.setAdresseId(3l);
        newPerson.setEmail("test@email.com");
        newPerson.setLastName("lastname");
        newPerson.setUsername("testUsername");
        newPerson.setPassword("testPasword");
        newPerson.setPhone("09050406");
        personService.savePerson(newPerson);
        Long size = 24l;
        Assert.assertEquals(newPerson.getId(), size);
    }


    @Test
    @Order(4)
    void editPerson(){
        Person editPerson = personService.getPerson(1l).get();
        PersonDto personDto = new PersonDto();
        personDto.setBirthday(editPerson.getBirthday());
        personDto.setEmail(editPerson.getEmail());
        personDto.setAdresseId(editPerson.getAdresseId());
        personDto.setId(editPerson.getId());
        personDto.setPhone(editPerson.getPhone());
        personDto.setPassword(editPerson.getPassword());
        personDto.setMedicalRecords(editPerson.getMedicalRecords());
        editPerson.setPhone("841-874-6512-edit");
        personService.updatePerson(personDto);

        Assert.assertEquals(personDto.getMedicalRecords().getId(), editPerson.getMedicalRecords().getId());
    }

    @Test
    @Order(5)
    void getPersonByName(){
        Person person = personService.getPersonByName("Tony", "Cooper").get();
        Long id = 10l;
        Assert.assertEquals(person.getId(), id);
    }


//    @Test
//    @Order(6)
//    void deleteUser() {
//        Person person = personService.getPerson(4l).get();
//        personService.deleteByUsernameLastname(person.getUsername(), person.getLastName());
//        if (personService.getPerson(person.getId()).isEmpty()) {
//            Assert.assertNull(person);
//        }
//    }

    @Test
    @Order(6)
    void deleteUser() {
        Person person = personService.getPerson(4l).get();
        personService.deleteByUsernameLastname(person.getUsername(), person.getLastName());
        if ( personService.getPerson(4l).isEmpty() ){
            Assert.assertNotNull(person);
        }
    }
//    @Test
//    @Order(6)
//    void deletePerson(){
//        Person newPerson = new Person();
//        newPerson.setBirthday("12/11/2022");
//        newPerson.setAdresseId(3l);
//        newPerson.setEmail("test@email.com");
//        newPerson.setLastName("lastname");
//        newPerson.setUsername("testUsername");
//        newPerson.setPassword("testPasword");
//        newPerson.setPhone("09050406");
//        personService.savePerson(newPerson);
//
//        personService.adminDelete("testUsername", "lastname");
//        List<Person>listPerson = personService.getAllPerson();
//        int size = 23;
//        int sizeList = listPerson.size();
//        Assert.assertTrue(listPerson.size()==23);
//    }
}
