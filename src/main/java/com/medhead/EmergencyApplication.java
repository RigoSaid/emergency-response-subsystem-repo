package com.medhead;


import com.medhead.entity.Call;
import com.medhead.repository.EmergencyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EmergencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmergencyApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(EmergencyRepository repository) {
        return (args) -> {
            repository.save(new Call(new Date(), "Said"));
            repository.save(new Call(new Date(), "Paul"));
            repository.save(new Call(new Date(), "Justine"));

        };
    }
}
