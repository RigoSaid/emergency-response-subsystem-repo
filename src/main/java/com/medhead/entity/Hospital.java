package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

}
