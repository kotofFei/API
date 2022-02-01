package com.example.IP.models;

import javax.persistence.*;

@Entity
@Table(name = "zal")
public class Zal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @OneToOne(optional = false, mappedBy = "zal")
    private Zdanie owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Zal(String number) {
        this.number = number;
    }

    public Zal() {

    }
}