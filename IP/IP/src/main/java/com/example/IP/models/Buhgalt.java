package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Buhgalt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String viruchka;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String colBooks;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String month;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViruchka() {
        return viruchka;
    }

    public void setViruchka(String viruchka) {
        this.viruchka = viruchka;
    }

    public String getColBooks() {
        return colBooks;
    }

    public void setColBooks(String colBooks) {
        this.colBooks = colBooks;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public Buhgalt(String viruchka, String colBooks, String month) {
        this.viruchka = viruchka;
        this.colBooks = colBooks;
        this.month = month;
    }

    public Buhgalt() {
    }
}

