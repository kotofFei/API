package com.example.School.reposit;

import com.example.School.models.Zurnal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZurnalRepository extends CrudRepository<Zurnal, Long>{
    List<Zurnal> findByName(String Name);
    List<Zurnal> findByNameContaining(String Name);
}
