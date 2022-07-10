package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.dto.AllergiesDto;
import com.brief.safetyNetAlerts.dto.MedicationDto;
import com.brief.safetyNetAlerts.model.Allergies;
import com.brief.safetyNetAlerts.model.Medications;
import com.brief.safetyNetAlerts.repository.AllergiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergiesServiceImpl {

    @Autowired
    private AllergiesRepository allergiesRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Allergies saveAllergie(Allergies allergies){
        Allergies allergie = allergiesRepository.save(allergies);
        return allergie;
    }

    public List<Allergies> getAllAllergies() {
        return allergiesRepository.findAll();
    }

    public Optional<Allergies> getAllergie(final Long id) {
        return allergiesRepository.findById(id);
    }


    public Allergies updateAllergie(AllergiesDto allergiesDto){

        System.out.println(allergiesDto);
        Allergies medication = modelMapper.map(allergiesDto, Allergies.class);
        System.out.println(medication);
        return allergiesRepository.save(medication);
    }
    public void deleteAllergie(Long id){
        allergiesRepository.deleteById(id);
    }

}
