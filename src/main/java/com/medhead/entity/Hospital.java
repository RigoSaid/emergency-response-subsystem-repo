package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
public class Hospital {
    @Id
    private Long id;
    private String name;
    private Double distance;
    @Transient
    private Location location;
    private Long nombresLitDisponible;
    @Transient
    private List<String> specialities = new ArrayList<>();

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", nombresLitDisponible=" + nombresLitDisponible +
                ", specialities=" + specialities +
                ", distance=" + distance +
                '}';
    }

    public Hospital() {

    }

    public Hospital(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public List<String> specialityList() {
        return Arrays.asList("Brûlre", "Cardiologie");
    }
}
