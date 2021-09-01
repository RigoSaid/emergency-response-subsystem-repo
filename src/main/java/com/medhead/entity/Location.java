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
    private Double  latitude;
    private Double longitude;
    private String adress;

    public Location() {

    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Location(Double latitude, Double longitude, String adress) {
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
