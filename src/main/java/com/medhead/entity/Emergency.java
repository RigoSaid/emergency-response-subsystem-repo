package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Emergency {
    @Id
    private Long id;
    @OneToOne
    Location location;

    @Transient
    private List<Patient> patients = new ArrayList<>();

    public Emergency() {

    }

    public Emergency(Long id, List<Patient> patients) {
        this.patients = patients;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


    @Override
    public String toString() {
        return "Emergency{" +
                "location=" + location +
                ", patients=" + patients +
                '}';
    }


}
