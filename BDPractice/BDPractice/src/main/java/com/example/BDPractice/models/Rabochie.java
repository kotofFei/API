package com.example.BDPractice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rabochie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float zp;
    private String Name;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getZp() {
        return zp;
    }

    public void setZp(Float zp) {
        this.zp = zp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Rabochie(Float date,String role, String Name) {
        this.zp = zp;
        this.role = role;
        this.Name = Name;
    }

    public Rabochie() {
    }
}
