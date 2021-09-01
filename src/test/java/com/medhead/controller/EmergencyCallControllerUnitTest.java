package com.medhead.controller;


import com.medhead.entity.Emergency;
import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import com.medhead.services.EmergencyCallService;
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
    void nearlyHospital_should_be_saint_denis() {
        EmergencyCallService emergencyCallService = new EmergencyCallService();
        Emergency emergency = new Emergency();
        emergency.setId(2L);
        emergency.setDistance(32.2);
        emergency.setSpeciality("Anesthésie");
        Hospital response = emergencyCallService.getHospitalList(emergency);

        assertEquals("saint denis", response.getName());
    }
}
