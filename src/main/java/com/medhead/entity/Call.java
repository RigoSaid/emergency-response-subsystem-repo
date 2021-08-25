package com.medhead.entity;

import lombok.Getter;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Getter
@ToString
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private Date dateCall;
    private String callerName;

    public Call(){

    }

    public Call( Date dateCall, String callerName) {
        this.dateCall = new Date ();
        this.callerName = callerName;
    }
}
