package com.example.IP.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="employ")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    private String firstname, lastname, thirdname, email;
    @Pattern(regexp = "7\\([0-9]{3}\\)-[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "Формат: 7(999)-999-99-99")
    private String phone;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Post post;


}
