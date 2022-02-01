package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не должно быть пустым!")
    private String ulica;
    @NotEmpty(message = "Поле не должно быть пустым!")
    private String town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String Town) {
        this.town = Town;
    }


    public Adress(String ulica, String Town) {
        this.ulica = ulica;
        this.town = Town;
    }

    public Adress() {
    }
}

