package com.medhead.controller;

import com.medhead.entity.Call;
import com.medhead.entity.Emergency;
import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class EmergencyCallController {

    private final CallRepository callRepository;
    private final EmergencyRepository emergencyRepository;

    public EmergencyCallController (CallRepository callRepository, EmergencyRepository emergencyRepository) {
        this.callRepository  = callRepository;
        this.emergencyRepository = emergencyRepository;
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



    @GetMapping(value = "/nearlyHospitals/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> findNearHospital (Location location, Emergency emergency) {
        Hospital hospital = null;
        return Arrays.asList("Hospital Nanterre", "Saint martin Hospital");

    }
}
