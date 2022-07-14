package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.FireStations;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FireStationRepositoryTest {
    @Autowired
    FireStationRepository fireStationRepository;
    FireStations fireStations = new FireStations();


    @Test
    @Order(1)
    void getAllFS(){
        List<FireStations> fireStations = fireStationRepository.findAll();
        int size = 13;
        Assert.assertEquals(fireStations.size(), size);
    }

    @Test
    @Order(2)
    void getById(){
        String address = "29 15th St";
        FireStations fireStations = fireStationRepository.findById(2l).get();
        Assert.assertEquals(fireStations.getAddress(), address);
    }

    @Test
    @Order(4)
    void addFS() {
        FireStations fireStations = new FireStations();
        fireStations.setStation(4);
        fireStations.setAddress("644 Gershwin Cir");
        fireStationRepository.save(fireStations);
        Long size = 14l;
        Assert.assertEquals(fireStations.getId(), size);
    }

    @Test
    @Order(4)
    void delete(){
        FireStations fireStations = fireStationRepository.findById(1l).get();
        fireStationRepository.delete(fireStations);
//        FireStations fireStationss = fireStationRepository.findById(1l).get();
//        Assert.assertEquals(fireStations, fireStationss);
//        fireStationRepository.deleteById(fireStations.getId());
        if ( fireStationRepository.findById(1l).isEmpty() ){
            Assert.assertNotNull(fireStations);
        }
    }
}
