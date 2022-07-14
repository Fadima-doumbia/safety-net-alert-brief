package com.brief.safetyNetAlerts.service.ServiceImpl;

import com.brief.safetyNetAlerts.service.FireStationService;
import com.brief.safetyNetAlerts.dto.FireStationsDto;
import com.brief.safetyNetAlerts.model.FireStations;
import com.brief.safetyNetAlerts.repository.FireStationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireStationServiceImpl implements FireStationService {
     @Autowired
     public FireStationRepository stationRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FireStations> stationList() { return stationRepository.findAll(); }

    @Override
    public Optional<FireStations> stationListId(Long id) { return stationRepository.findById(id); }

    @Override
    public FireStations addStation(FireStations station) {
        return stationRepository.save(station);
    }

    @Override
    public FireStations editStation(FireStationsDto stationsDto) {
        FireStations fireStations = modelMapper.map(stationsDto, FireStations.class);
        return stationRepository.save(fireStations);
    }

    @Override
    public void deleteStation(Long id) {
        Optional<FireStations>station = stationRepository.findById(id);
            if (station != null){
                stationRepository.delete(station.get());
            }
    }
}
