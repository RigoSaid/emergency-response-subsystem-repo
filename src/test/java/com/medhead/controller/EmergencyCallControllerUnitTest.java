package com.medhead.controller;


import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

public class EmergencyCallControllerUnitTest {

    @Autowired
    EmergencyCallController emergencyCallController;
    private final CallRepository callRepository = null;
    private final EmergencyRepository emergencyRepository = null;

    @Test
    void testHello_should() {
        emergencyCallController = new EmergencyCallController(callRepository,emergencyRepository);
        String response = emergencyCallController.helloController("Rigo");
        assertEquals("Hello, Rigo", response);
    }
}
