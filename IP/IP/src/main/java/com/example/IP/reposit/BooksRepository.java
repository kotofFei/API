package com.example.School.reposit;

import com.example.School.models.Predmet;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PredmetRepository  extends CrudRepository<Predmet, Long>{
    List<Predmet> findByName(String Name);
    List<Predmet> findByNameContaining(String Name);
}
