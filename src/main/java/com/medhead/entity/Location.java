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
     Long latitude;
     Long longitude;
     String adress;

    public Location() {

    }
    public Location(Long latitude, Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public Location(Long latitude, Long longitude, String adress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.adress = adress;

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
