package com.example.BDPractice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zurnal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float date;
    private Float Mark;
    private String Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDate() {
        return date;
    }

    public void setDate(Float date) {
        this.date = date;
    }

    public Float getMark() {
        return Mark;
    }

    public void setMark(Float Mark) {
        this.Mark = Mark;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Zurnal(Float date,Float Mark, String Name) {
        this.date = date;
        this.Mark = Mark;
        this.Name = Name;
    }

    public Zurnal() {
    }
}
