package com.medhead.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Emergency {
    @Id
    private Long id;

    @Transient
    private Patient patients;
    private String speciality;
    private Double distance;

    public Emergency() {
    }
    

    @Override
    public String toString() {
        return "Emergency{" +
                "id=" + id +
                ", patients=" + patients +
                ", speciality=" + speciality +
                ", distance=" + distance +
                '}';
    }


}
