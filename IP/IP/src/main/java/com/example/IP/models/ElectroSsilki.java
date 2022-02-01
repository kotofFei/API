package com.example.IP.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "electro")
public class ElectroSsilki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ssilka;

    @ManyToMany
    @JoinTable(name="electro_magazin",
    joinColumns = @JoinColumn(name = "electro_id"),
    inverseJoinColumns = @JoinColumn(name = "magazin_id"))
    private List<MagazinBiblio> magazinBiblios;

    public ElectroSsilki(String ssilka) {
        this.ssilka = ssilka;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsilka() {
        return ssilka;
    }

    public void setSsilka(String ssilka) {
        this.ssilka = ssilka;
    }

    public List<MagazinBiblio> getMagazinBiblios() {
        return magazinBiblios;
    }

    public void setMagazinBiblios(List<MagazinBiblio> magazinBiblios) {
        this.magazinBiblios = magazinBiblios;
    }

    public ElectroSsilki(String ssilka, List<MagazinBiblio> magazinBiblios) {
        this.ssilka = ssilka;
        this.magazinBiblios = magazinBiblios;
    }
    public ElectroSsilki() {
    }

}
