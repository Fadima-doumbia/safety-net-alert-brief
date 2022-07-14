package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.service.ServiceImpl.MedicationServiceImpl;
import com.brief.safetyNetAlerts.dto.MedicationDto;
import com.brief.safetyNetAlerts.model.Medications;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/medications")
public class MedicationsController {
    @Autowired
    MedicationServiceImpl medicationsService;
    private final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/{medicationId}")
    public Optional<Medications> getAddress(@PathVariable("medicationId") final Long medicationId){
        return medicationsService.getMedication(medicationId);
    }

    @GetMapping("/{name}")
    public Optional<Medications> getMedicationName(@PathVariable("name") final String name){
        return medicationsService.getMedicationsByName(name);
    }

    @GetMapping()
    public List<Medications> getAllAddress(){
        return medicationsService.getAllMedications();
    }

    @PostMapping("/{email}")
    public Medications saveAddress(@RequestBody Medications medications, @PathVariable("email") final String email){
        return medicationsService.createNewMedication(medications, email);
    }

    @PostMapping()
    public Medications saveAddressSimple(@RequestBody Medications medications){
        return medicationsService.saveMedicationSimple(medications);
    }

    @DeleteMapping("/{medicationId}")
    public void deleteMedications (@PathVariable("medicationId") final Long medicationId) {
        medicationsService.adminDeleteMedication(medicationId);
    }

    @PutMapping()
    public Medications updateAddress(@RequestBody MedicationDto medicationsDto){
        return medicationsService.updateMedication(medicationsDto);
    }
}
