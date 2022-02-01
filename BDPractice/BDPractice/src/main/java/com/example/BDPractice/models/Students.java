package com.example.BDPractice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float curs;
    private String FIO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCurs() {
        return curs;
    }

    public void setCurs(Float curs) {
        this.curs = curs;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Students(Float curs, String FIO) {
        this.curs = curs;
        this.FIO = FIO;
    }

    public Students() {
    }
}


