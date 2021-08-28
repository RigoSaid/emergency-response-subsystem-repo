package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Location {
    @Id
    private Long id;
    private Long latitude;
    private Long longitude;
    private String adress;

    public Location() {

    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", adress='" + adress + '\'' +
                '}';
    }
}
