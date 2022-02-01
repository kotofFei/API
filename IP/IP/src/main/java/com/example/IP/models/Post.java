package com.example.IP.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    private String name;

    private Integer salary;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Collection<com.example.IP.models.Employee> post;
}
