package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.Service.FireStationService;
import com.brief.safetyNetAlerts.dto.FireStationsDto;
import com.brief.safetyNetAlerts.model.FireStations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/safetyNetAlets/fireStation"})
public class FireStationController {

    @Autowired
    FireStationService fireStationService;

    @GetMapping("")
    public List<FireStations> stationsList(){ return fireStationService.stationList();}

    @PostMapping("")
    public FireStations addStation(@RequestBody FireStations station){ return fireStationService.addStation(station); }

    @GetMapping(path = {"/{id}"})
    public Optional<FireStations> stationListId(@PathVariable("id")Long id){ return fireStationService.stationListId(id);}

    @PutMapping(path = {"/edit/{id}"})
    public FireStations editStation (@RequestBody FireStationsDto station, @PathVariable("id")Long id){
        station.setId(id);
        return fireStationService.editStation(station);
    }

    @DeleteMapping(path = {"delete/{id}"})
    public void deleteStation(@PathVariable Long id){ fireStationService.deleteStation(id);}

}
