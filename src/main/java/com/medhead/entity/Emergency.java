package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Emergency {
    @Id
    private Long id;
    @OneToOne
    Location location;

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

    @Transient
    private List<Patient> patients = new ArrayList<>();
    enum typeOfEmergency {
        respiratoire , Urologie , sofrologie
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "location=" + location +
                ", patients=" + patients +
                '}';
    }



    public Emergency() {

    }

    public Emergency(Long id, List<Patient> patients) {
        this.patients = patients;
        this.location = location;
    }


}
