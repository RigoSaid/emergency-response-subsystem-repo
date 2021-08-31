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
    @OneToOne(fetch = FetchType.LAZY)
    private Location location;


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
