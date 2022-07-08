package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.Service.ServiceImpl.PersonServiceImpl;
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

    @PostMapping("/person")
    public Person savePersonAddress(@RequestBody Person personn){
        return personService.savePerson(personn);
    }

    @GetMapping("/{personId}")
    public Optional<Person> getPerson(@PathVariable("personId") final Long personId){
        return personService.getPerson(personId);
    }

    @GetMapping()
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }

    @PostMapping("/p")
    public Person savePersonSimple(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @DeleteMapping("/{personId}")
    public void personDelete (@PathVariable("personId") final Long personId){
        personService.adminDeletePerson(personId);
    }

//    @PutMapping("")
//    public Person updatePerson(@RequestBody PersonDto personDto){
//        return personService.updatePerson(personDto);
//    }
}
