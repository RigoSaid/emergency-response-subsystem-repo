package com.medhead.controller;


import com.medhead.entity.Emergency;
import com.medhead.entity.Location;
import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmergencyCallControllerUnitTest {

    @Autowired
    EmergencyCallController emergencyCallController;
    private final CallRepository callRepository = null;
    private final EmergencyRepository emergencyRepository = null;

    @Test
    void nearlyHospital_should_be_nanterre() {
        emergencyCallController = new EmergencyCallController(callRepository,emergencyRepository);
        Location location = new Location();
        Emergency emergency = new Emergency();
        List<String> response = emergencyCallController.findNearHospital(location,emergency);
        assertEquals("Hospital Nanterre", response.get(0));
    }
}
