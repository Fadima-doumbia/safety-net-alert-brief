package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.repository.AddressRepository;
import com.brief.safetyNetAlerts.service.ServiceImpl.AddressServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;*/
;


//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)Ne pas decommenter
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(controllers = AddressController.class)
public class AddressControllerTest {
//    @Mock
//    private AddressController addressController;
//    @InjectMocks
//    private PersonService iPersonService;
//    @Mock
//    private PersonRepository personRepository;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressServiceImpl addressService;
//    @Mock
//    private PersonServiceImpl personServic;

    @MockBean
    private AddressRepository addressRepository;
    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    void shouldCreateTutorial() throws Exception {
//        Address address = new Address(1, "80 avenue", "93290", "tremblay");
//
//        address.setAddress("zerty");
//        address.setZip("azerty");
//        address.setCity("zertyu");
//        mockMvc.perform(post("/api/tutorials").contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(address)))
//                .andExpect(status().isCreated())
//                .andDo();
//    }

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("api/safetyNetAlets/address"))
                .andExpect(status().isOk());
    }



//    @InjectMocks
//    private IPersonService iPersonService
//    public void itShouldCreatePerson() {
//        Person p = new Person();
//        p.setUsername("Bamab");
//        p.setLastName("Ahmadu");
//        p.setEmail("bamba@mail.com");
//        when(personRepository.save(p)).thenReturn(p);
//        Person savedPerson = personServic.savePerson(p);
//        Assert.assertEquals(savedPerson.getUsername(),
//                p.getUsername());
//    }

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
