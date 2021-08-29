package com.medhead.controller;

import com.medhead.entity.Emergency;
import com.medhead.entity.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmergencyCallControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCalls() {
    }

    @Test
    void getCall() {
    }

    @Test
    void createCall() {
    }
    @Test
    public void getsAllCall() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/call")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void it_should_return_hospitals_() throws Exception {
        Emergency emergency = new Emergency();
        emergency.setLocation(new Location(120L,152530L)) ;
        mockMvc.perform(MockMvcRequestBuilders.post("/call")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}