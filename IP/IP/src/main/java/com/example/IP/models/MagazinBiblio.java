package com.example.IP.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "magazin")
public class MagazinBiblio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "electro_magazin",
            joinColumns = @JoinColumn(name = "magazin_id"),
            inverseJoinColumns = @JoinColumn(name = "electro_id"))
    private List<ElectroSsilki> electroSsilkis;

    public MagazinBiblio(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ElectroSsilki> getElectroSsilkis() {
        return electroSsilkis;
    }

    public void setElectroSsilkis(List<ElectroSsilki> electroSsilkis) {
        this.electroSsilkis = electroSsilkis;
    }

    public MagazinBiblio(String name, List<ElectroSsilki> electroSsilkis) {
        this.name = name;
        this.electroSsilkis = electroSsilkis;
    }

    public MagazinBiblio() {
    }
}
