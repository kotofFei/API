package com.example.IP.reposit;

import com.example.IP.models.Adress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdressRepository extends CrudRepository<Adress, Long> {
    List<Adress> findByTown(String Town);
}

