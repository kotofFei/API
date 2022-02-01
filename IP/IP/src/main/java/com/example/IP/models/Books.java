package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String author;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String toms;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getToms() {
        return toms;
    }

    public void setToms(String toms) {
        this.toms = toms;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Books(String author, String toms, String name) {
        this.author = author;
        this.toms = toms;
        this.name = name;
    }

    public Books() {
    }
}
