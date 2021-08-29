package com.medhead.services;

import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmergencyCallService {

    public List<Hospital> findHospital(Location location) {

        List<Hospital> hospitalsByRecommandation = new ArrayList<>();
        return hospitalsByRecommandation;

    }

}
