package com.example.IP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String statistic;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String contact;
    @NotEmpty(message = "Поле не может быть пустым!")
    private String hoursOfWork;


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(String hoursOfWork) {this.hoursOfWork = hoursOfWork; }


    public Information(String statistic, String contact, String hoursOfWork) {
        this.statistic = statistic;
        this.contact = contact;
        this.hoursOfWork = hoursOfWork;
    }

    public Information() {
    }
}
