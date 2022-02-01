package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Directors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String FIO;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String otdel;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String rab;


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

    public String getOtdel() {
        return otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getRab() {
        return rab;
    }

    public void setRab(String rab) {this.rab = rab; }


    public Directors(String FIO, String otdel, String rab) {
        this.FIO = FIO;
        this.otdel = otdel;
        this.rab = rab;
    }

    public Directors() {
    }
}
