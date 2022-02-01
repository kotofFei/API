package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Pisateli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String FIO;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String staz;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String book;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getStaz() {
        return staz;
    }

    public void setStaz(String staz) {
        this.staz = staz;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }


    public Pisateli(String FIO, String staz, String book) {
        this.FIO = FIO;
        this.staz = staz;
        this.book = book;
    }

    public Pisateli() {
    }
}
