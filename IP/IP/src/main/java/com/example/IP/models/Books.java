package com.example.School.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String hours;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String teachersCount;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String curs) {
        this.hours = curs;
    }

    public String getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(String teachersCount) {
        this.teachersCount = teachersCount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Predmet(String hours,String teachersCount, String name) {
        this.hours = hours;
        this.teachersCount = teachersCount;
        this.name = name;
    }

    public Predmet() {
    }
}
