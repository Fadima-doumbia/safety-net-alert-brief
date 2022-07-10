package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.model.MedicalRecords;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/medicalRecords")

public class MedicalRecordsController {

    @Autowired
    com.brief.safetyNetAlerts.Service.ServiceImpl.MedicalRecordsServiceImpl medicalRecordsService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{medicalRecordsId}")
    public Optional<MedicalRecords> getMedicalRecords(@PathVariable("medicalRecordsId") final Long medicalRecordsId){
        return medicalRecordsService.getMedicalRecords(medicalRecordsId);
    }

    @GetMapping()
    public List<MedicalRecords> getAllMedicalRecords(){
        return medicalRecordsService.getAllMedicalRecords();
    }

    @PostMapping()
    public MedicalRecords saveMedicalRecords(@RequestBody MedicalRecords medicalRecords){
        return medicalRecordsService.saveMedicalRecords(medicalRecords);
    }

    @DeleteMapping("/{medicalRecordsId}")
    public void deleteMedicalRecords (@PathVariable("medicalRecordsId") final Long medicalRecordsId) {
        medicalRecordsService.deleteMedicalRecords(medicalRecordsId);
    }

    @PutMapping("/{id}")
    public MedicalRecords updateMedicalRecords(@RequestBody MedicalRecords medicalRecords, @PathVariable("id") Long id ){
        return medicalRecordsService.updateMedicalRecords1(medicalRecords, id);
    }
}
