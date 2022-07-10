package com.brief.safetyNetAlerts.Service;

import com.brief.safetyNetAlerts.model.FireStations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FireStationService {
    List<FireStations> stationList();
    Optional<FireStations> stationListId(Long id);
    FireStations addStation(FireStations station);
    FireStations editStation(FireStations station);
    void deleteStation (Long id);
}
