package com.example.BDPractice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float hours;
    private Float teachersCount;
    private String Name;

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

    public Float getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(Float teachersCount) {
        this.teachersCount = teachersCount;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Predmet(Float hours,Float teachersCount, String Name) {
        this.hours = hours;
        this.teachersCount = teachersCount;
        this.Name = Name;
    }

    public Predmet() {
    }
}
