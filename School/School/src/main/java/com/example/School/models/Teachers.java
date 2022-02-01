package com.example.BDPractice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float hours;
    private String FIO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float curs) {
        this.hours = curs;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Teachers(Float hours, String FIO) {
        this.hours = hours;
        this.FIO = FIO;
    }

    public Teachers() {
    }
}
