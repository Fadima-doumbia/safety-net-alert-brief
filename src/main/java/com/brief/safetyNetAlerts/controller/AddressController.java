package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.service.ServiceImpl.AddressServiceImpl;
import com.brief.safetyNetAlerts.dto.AddressDto;
import com.brief.safetyNetAlerts.model.Address;
import com.brief.safetyNetAlerts.repository.AddressRepository;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/address")
public class AddressController {
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{addressId}")
    public Optional<Address> getAddress(@PathVariable("addressId") final Long addressId){
        return addressService.getAddress(addressId);
    }

    @GetMapping()
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @PostMapping("/{email}")
    public Address saveAddress(@RequestBody Address address, @PathVariable("email") final String email){
            return addressService.createNewAddress(address, email);
    }

    @PostMapping()
    public Address saveAddressSimple(@RequestBody Address address){
        return addressService.saveAddressSimple(address);
    }

    @DeleteMapping("/{addressId}")
    public void addressDelete (@PathVariable("addressId") final Long addressId){
        addressService.adminDeleteAddress(addressId);
    }

    @PutMapping("")
    public Address updateAddress(@RequestBody AddressDto addressDto){
        return addressService.updateAddress(addressDto);
    }
}
