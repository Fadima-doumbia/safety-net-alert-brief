package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.service.ServiceImpl.AddressPersonServiceImpl;
import com.brief.safetyNetAlerts.model.AdressPerson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/addressPersons")
public class AddressPersonController {
    @Autowired
    AddressPersonServiceImpl addressPersonService;
    @PostMapping("")
    public AdressPerson savePersonSimple(@RequestBody AdressPerson adressPerson){
        return addressPersonService.saveAddressPerson(adressPerson);
    }
}
