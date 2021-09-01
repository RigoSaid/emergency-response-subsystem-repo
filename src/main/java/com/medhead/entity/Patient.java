package com.medhead.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    private Long id;
    private String name;
    private Double age;

    public Patient(String name, Double age) {
        this.name = name;
        this.age = age;
    }
}
