package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.AddressPersonDto;
import com.brief.safetyNetAlerts.model.AdressPerson;
import com.brief.safetyNetAlerts.repository.AddressPersonRepository;
import com.brief.safetyNetAlerts.repository.AddressRepository;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class AddressPersonServiceImpl {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressPersonRepository addressPersonRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public AdressPerson saveAddressPerson(AdressPerson adressPerson){
//        Address newAddress = addressRepository.getById(address.getId());
//        Person person = personRepository.getById(p.getId());
//        AdressPerson adressPerson = new AdressPerson();
//        adressPerson.setPerson(person);
//        adressPerson.setAddress(newAddress);
        return addressPersonRepository.save(adressPerson);
    }

    public List<AdressPerson> getAllAddress() {
        return addressPersonRepository.findAll();
    }

    public Optional<AdressPerson> getAddress(Long id) {
        return addressPersonRepository.findById(id);
    }

//    public Optional<AdressPerson> getAddressByNAme(String id) {
//        return addressPersonRepository.findById(id);
//    }

    public AdressPerson updateAddress(AddressPersonDto addressDto){
        AdressPerson address = modelMapper.map(addressDto, AdressPerson.class);
        return addressPersonRepository.save(address);
    }

    public void adminDeleteAddress(Long id){
        addressPersonRepository.deleteById(id);
    }

}
