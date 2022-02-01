package com.example.School.reposit;

import com.example.School.models.Reg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegRepository extends CrudRepository<Reg, Long> {
    List<Reg> findByLogin(String Login);
}
