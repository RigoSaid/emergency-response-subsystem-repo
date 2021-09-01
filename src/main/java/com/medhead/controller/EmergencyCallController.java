package com.medhead.controller;

import com.medhead.EmergencyApplication;
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
import java.util.*;

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
    public List<String> findNearHospital () {
        Location locationCall = new Location();
        locationCall.setLatitude(48.93625142006256);
        locationCall.setLongitude(2.349921757458698);


        return Arrays.asList("Hospital Nanterre", "Saint martin Hospital");
    }
    public  Hospital  getHospitalList(Emergency emergency) {
        List <Hospital> hospitalList = new ArrayList<Hospital>();
        Location hospitalLocation1 =
                new Location(48.93114683117722, 2.361165117035444);
        Hospital hospital1 = new Hospital();
        hospital1.setLocation(hospitalLocation1);
        hospital1.setNombresLitDisponible(3L);
        hospital1.setName("Casa Nova");
        hospital1.setDistance(80.2);
        List<String> specialityList = new ArrayList<String>();
        specialityList.add("Brulure");
        specialityList.add("Cardilogie");
        hospital1.setSpecialities(specialityList);

        specialityList.clear();
        Location hospitalLocation2 =
                new Location(48.93622901400626, 2.3769266473219144);
        Hospital hospital2 = new Hospital();
        hospital1.setLocation(hospitalLocation1);
        hospital2.setNombresLitDisponible(3L);
        hospital2.setName("saint denis");
        specialityList.add("Anesthésie");
        specialityList.add("Allergie");
        hospital2.setDistance(72.2);
        hospitalList.add(hospital1);
       Hospital nearHospital =  hospitalList.stream()
                .min(Comparator.
                        comparingDouble(h -> Math.abs(h.getDistance() - emergency.getDistance())))
                .orElseThrow(() -> new NoSuchElementException("No value present"));
       System.out.println(nearHospital);

        return nearHospital;
    }
    private Hospital getNearlyHospital(Emergency emergency) {
        return null;
    }
}
