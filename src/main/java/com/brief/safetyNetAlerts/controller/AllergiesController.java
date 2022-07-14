package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.service.ServiceImpl.AllergiesServiceImpl;
import com.brief.safetyNetAlerts.dto.AllergiesDto;
import com.brief.safetyNetAlerts.model.Allergies;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/safetyNetAlets/allergies")
public class AllergiesController {

    @Autowired
    AllergiesServiceImpl allergiesService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{allergieId}")
    public Optional<Allergies> getAllergie(@PathVariable("allergieId") final Long allergieId){
        return allergiesService.getAllergie(allergieId);
    }

    @GetMapping()
    public List<Allergies> getAllAllergies(){
        return allergiesService.getAllAllergies();
    }

    @PostMapping()
    public Allergies saveAllergie(@RequestBody Allergies allergies){
        return allergiesService.saveAllergie(allergies);
    }

    @DeleteMapping("/{allergieId}")
    public void deleteAllergies (@PathVariable("allergieId") final Long allergieId) {
        allergiesService.deleteAllergie(allergieId);
    }

    @PutMapping("/update")
    public Allergies updateAllergie(@RequestBody AllergiesDto allergiesDto){
        return allergiesService.updateAllergie(allergiesDto);
    }

}
