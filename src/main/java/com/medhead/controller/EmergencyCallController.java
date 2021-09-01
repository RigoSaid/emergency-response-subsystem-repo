package com.medhead.controller;

import com.medhead.EmergencyApplication;
import com.medhead.entity.Call;
import com.medhead.entity.Emergency;
import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import com.medhead.repository.HospitalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
public class EmergencyCallController {

    private final CallRepository callRepository;
    private final EmergencyRepository emergencyRepository;
    private final HospitalRepository hospitalRepository;

    public EmergencyCallController (CallRepository callRepository, EmergencyRepository emergencyRepository
    ,HospitalRepository hospitalRepository) {
        this.callRepository  = callRepository;
        this.emergencyRepository = emergencyRepository;
        this.hospitalRepository = hospitalRepository;
    }
    @GetMapping(value = "/call", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Call> getCalls() {
        return callRepository.findAll();

    }
    @GetMapping(value = "/call/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Call getCall(@PathVariable long id){
        return callRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid Call id %s", id)));
    }
    @PostMapping(value = "/call", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Call CreateCall(@Valid @RequestBody Call call) {
        return callRepository.save(call);
    }

    @GetMapping(value = "/emergency", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Emergency> getEmergency() {
        return emergencyRepository.findAll();

    }
    @GetMapping(value = "/hospitals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Hospital> getHospitals() {
        return hospitalRepository.findAll();

    }
    @GetMapping(value = "/nearlyHospitals/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> findNearHospital () {
        Location locationCall = new Location();
        locationCall.setLatitude(48.93625142006256);
        locationCall.setLongitude(2.349921757458698);


        return Arrays.asList("Hospital Nanterre", "Saint martin Hospital");
    }

}
