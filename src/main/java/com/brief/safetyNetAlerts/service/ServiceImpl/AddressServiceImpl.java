package com.brief.safetyNetAlerts.service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.AddressDto;
import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.model.Person;
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
public class AddressServiceImpl {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public Address createNewAddress(Address address, String email){
        Optional<Person> personOptional = personRepository.findByEmail(email);
        Address newAddress = null;
        if(personOptional.isPresent()){
            newAddress = addressRepository.save(address);
        }
        return newAddress;
    }

    public Address saveAddressSimple(Address address){
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddress(Long id) {
        return addressRepository.findById(id);
    }

    public Optional<Address> getAddress(String address) {
        return addressRepository.findByAddress(address);
    }

    public Address updateAddress(AddressDto addressDto){
        Address address = modelMapper.map(addressDto, Address.class);
        return addressRepository.save(address);
    }

    public void adminDeleteAddress(Long id){
        addressRepository.deleteById(id);
    }

}
