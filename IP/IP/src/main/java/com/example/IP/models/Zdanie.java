package com.example.IP.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zdanie")
public class Zdanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itazi;
    @OneToOne(optional=false, cascade=CascadeType.DETACH)
    @JoinColumn (name="zal_id")
    private Zal zal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItazi() {
        return itazi;
    }

    public void setItazi(String itazi) {
        this.itazi = itazi;
    }

    public Zdanie(String itazi, Zal zal) {
        this.itazi = itazi;
        this.zal = zal;
    }

    public Zdanie() {
    }
}