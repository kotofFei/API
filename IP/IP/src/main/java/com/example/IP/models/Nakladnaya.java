package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Nakladnaya {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String dati;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String stoimost;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String postavchik;


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getDati() {
        return dati;
    }

    public void setDati(String dati) {
        this.dati = dati;
    }

    public String getStoimost() {
        return stoimost;
    }

    public void setStoimost(String stoimost) {
        this.stoimost = stoimost;
    }

    public String getPostavchik() {
        return postavchik;
    }

    public void setPostavchik(String postavchik) {this.postavchik = postavchik; }


    public Nakladnaya(String dati, String stoimost, String postavchik) {
        this.dati = dati;
        this.stoimost = stoimost;
        this.postavchik = postavchik;
    }

    public Nakladnaya() {
    }
}
