package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.PersonDto;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonRepository personRepository;

    private final ModelMapper modelMapper = new ModelMapper();

public Person savePerson(Person person){
    return personRepository.save(person);
}

    public Person savePersonSimple(Person person){
        Person person1 = personRepository.save(person);
        return person1;
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(final Long id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(PersonDto personDto){
        Person person = modelMapper.map(personDto, Person.class);
        return personRepository.save(person);
    }

    public void adminDeletePerson(Long id){
        personRepository.deleteById(id);
    }
}
