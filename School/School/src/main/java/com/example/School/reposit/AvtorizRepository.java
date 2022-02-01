package com.example.School.reposit;

import com.example.School.models.Avtoriz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvtorizRepository extends CrudRepository<Avtoriz, Long> {
    List<Avtoriz> findByLogin(String Login);
}
