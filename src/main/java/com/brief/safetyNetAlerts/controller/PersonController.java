package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.dto.PersonDto;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.service.ServiceImpl.PersonServiceImpl;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/persons")
public class PersonController {
    @Autowired
    PersonServiceImpl personService;
    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping("")
    public Person savePersonAddress(@RequestBody Person personn){
        return personService.savePerson(personn);
    }

    @GetMapping("/{personId}")
    public Optional<Person> getPerson(@PathVariable("personId") final Long personId){
        return personService.getPerson(personId);
    }

    @GetMapping("/{personId}/{lastname}")
    public Optional<Person> getPerson(@PathVariable("personId")  String personId,@PathVariable("lastname")  String lastname ){
        return personService.getPersonByName(personId, lastname);
    }

    @GetMapping()
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }

//    @PostMapping("/p")
//    public Person savePersonSimple(@RequestBody Person person){
//        return personService.savePerson(person);
//    }

    @PostMapping("/p")
    public Person savePersonSimple(@RequestBody Person person){
        return personService.savePersonSimple(person);
    }

    @DeleteMapping("/{personId}")
    public void personDelete (@PathVariable("personId") final Long personId){
        personService.adminDeletePerson(personId);
    }

    @DeleteMapping("/{username}/{lastname}")
    public String personDeleteByusernameLastname (@PathVariable("username") final String username,
                                                @PathVariable("lastname") final String lastname){
        return personService.adminDelete(username, lastname);
    }
    @DeleteMapping("/delete/{username}/{lastname}")
    public void deleteByusernameLastname (@PathVariable("username") final String username,
                                                  @PathVariable("lastname") final String lastname){
        personService.deleteByUsernameLastname(username, lastname);
    }

    @PutMapping("")
    public Person updatePerson(@RequestBody PersonDto personDto){
        return personService.updatePerson(personDto);
    }
}
