package com.medhead.services;

import com.medhead.entity.Emergency;
import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmergencyCallService {

    public    Hospital  getHospitalList(Emergency emergency) {
        List <Hospital> hospitalList = new ArrayList<Hospital>();
        Location hospitalLocation1 =
                new Location(48.93114683117722, 2.361165117035444);
        Hospital hospital1 = new Hospital();
        hospital1.setLocation(hospitalLocation1);
        hospital1.setNombresLitDisponible(3L);
        hospital1.setName("Casa Nova");
        hospital1.setNombresLitDisponible(0L);
        hospital1.setDistance(52.2);
        List<String> specialityList = new ArrayList<String>();
        specialityList.add("Brulure");
        specialityList.add("Cardilogie");
        specialityList.add("Anesthésie");
        hospital1.setSpecialities(specialityList);
        hospitalList.add(hospital1);

        specialityList.clear();
        Location hospitalLocation2 =
                new Location(48.93622901400626, 2.3769266473219144);
        Hospital hospital2 = new Hospital();
        hospital2.setLocation(hospitalLocation2);
        hospital2.setNombresLitDisponible(3L);
        hospital2.setName("saint denis");
        hospital2.setNombresLitDisponible(1L);
        specialityList.add("Anesthésie");
        specialityList.add("Allergie");
        hospital2.setSpecialities(specialityList);
        hospital2.setDistance(82.2);
        hospitalList.add(hospital2);
        Map<Double,Hospital> dis = new HashMap<>();
        specialityList.clear();

        Location hospitalLocation3 =
                new Location(48.93622901400626, 2.3769266473219144);
        Hospital hospital3 = new Hospital();
        hospital3.setLocation(hospitalLocation3);
        hospital3.setNombresLitDisponible(0L);
        hospital3.setName("saint martin");
        specialityList.add("Allergie");
        hospital3.setSpecialities(specialityList);
        hospital3.setDistance(42.2);
        hospitalList.add(hospital3);


        Hospital nearHospital =  hospitalList.stream().filter(hospital -> hospital.getNombresLitDisponible() > 0L)
                .min(Comparator.
                        comparingDouble(h -> Math.abs(h.getDistance() - emergency.getDistance()) ))

                .orElseThrow(() -> new NoSuchElementException("No value present"));

        return nearHospital;
    }

}
