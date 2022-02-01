package com.example.IP.models;

import javax.persistence.*;

public class MagazinBiblio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chastie;
    private String popular;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "graph_id")
    private Graph graph;

}
