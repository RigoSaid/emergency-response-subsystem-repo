package com.medhead;


import com.medhead.entity.Call;
import com.medhead.entity.Emergency;
import com.medhead.entity.Hospital;
import com.medhead.entity.Location;
import com.medhead.repository.CallRepository;
import com.medhead.repository.EmergencyRepository;
import com.medhead.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class EmergencyApplication {
    @Autowired
    HospitalRepository hospitalRepository;
    public static void main(String[] args) {


        SpringApplication apps = new SpringApplication(EmergencyApplication.class);
        apps.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        Emergency emergency = new Emergency();
        emergency.setDistance(32.2);
        emergency.setSpeciality("Anesthésie");
        Hospital h = getHospitalList(emergency);
        System.out.println("Found it " + h);
        apps.run(args);
    }

    @Bean
    public CommandLineRunner sampleData(CallRepository repository, EmergencyRepository emergencyRepository) {
        return (args) -> {
            repository.save(new Call(new Date(), "Said"));
            repository.save(new Call(new Date(), "Paul"));
            repository.save(new Call(new Date(), "Justine"));
            Emergency emergency = new Emergency();
            emergency.setDistance(32.2);
            emergency.setSpeciality("Anesthésie");
            emergencyRepository.save(emergency);
        };
    }
    public static   Hospital  getHospitalList(Emergency emergency) {
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
