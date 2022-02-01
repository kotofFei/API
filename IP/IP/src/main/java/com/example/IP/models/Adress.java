package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Adr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не должно быть пустым!")
    private String ul;
    @NotEmpty(message = "Поле не должно быть пустым!")
    private String town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return ul;
    }

    public void setAdress(String ul) {
        this.ul = ul;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String Town) {
        this.town = Town;
    }


    public Adr(String ul, String Town) {
        this.ul = ul;
        this.town = Town;
    }

    public Adr() {
    }
}

