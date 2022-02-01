package com.example.IP.reposit;

import com.example.IP.models.Readers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadersRepository extends CrudRepository<Readers, Long> {
    List<Readers> findByAge(String Age);
    List<Readers> findByFIO(String FIO);
    List<Readers> findByAgeContaining(String Age);
}

