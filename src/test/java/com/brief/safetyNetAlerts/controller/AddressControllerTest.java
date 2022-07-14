package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import com.brief.safetyNetAlerts.service.PersonService;
import com.brief.safetyNetAlerts.service.ServiceImpl.PersonServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {
    @Mock
    private PersonService personService;
    @InjectMocks
    private PersonService iPersonService;
    @Mock
    private PersonRepository personRepository;
//    @Test

    @Mock
    private PersonServiceImpl personServic;
//    @InjectMocks
//    private IPersonService iPersonService
    public void itShouldCreatePerson() {
        Person p = new Person();
        p.setUsername("Bamab");
        p.setLastName("Ahmadu");
        p.setEmail("bamba@mail.com");
        when(personRepository.save(p)).thenReturn(p);
        Person savedPerson = personServic.savePerson(p);
        Assert.assertEquals(savedPerson.getUsername(),
                p.getUsername());
    }

//    @Mock
//    private PersonService personService;
//    @InjectMocks
//    private IPersonService iPersonService;
//    @Mock
//    private PersonRepository personRepository;
//    @Test     public void itShouldCreatePerson() {
//        Person p = new Person();
//        p.setFirstName("Bamab");
//        p.setLastName("Ahmadu");
//        p.setEmail("bamba@mail.com");
//        when(personRepository.save(p)).thenReturn(p);
//        Person savedPerson = iPersonService.createPerson(p);
//        assertEquals(savedPerson.getFirstName(), p.getFirstName());
//    }
}
