package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.Service.FireStationService;
import com.brief.safetyNetAlerts.model.FireStations;
import com.brief.safetyNetAlerts.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireStationServiceImpl implements FireStationService {

     @Autowired
     public FireStationRepository stationRepository;

    @Override
    public List<FireStations> stationList() { return stationRepository.findAll(); }

    @Override
    public Optional<FireStations> stationListId(Long id) { return stationRepository.findById(id); }

    @Override
    public FireStations addStation(FireStations station) {
        return stationRepository.save(station);
    }

    @Override
    public FireStations editStation(FireStations station) {
        return stationRepository.save(station);
    }

    @Override
    public void deleteStation(Long id) {
        Optional<FireStations>station = stationRepository.findById(id);
            if (station != null){
                stationRepository.delete(station.get());
            }
    }
}
