package com.example.School.reposit;

import com.example.School.models.Teachers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeachersRepository extends CrudRepository<Teachers, Long> {
    List<Teachers> findByFIO(String FIO);
    List<Teachers> findByHours(String hours);
    List<Teachers> findByFIOContaining(String FIO);
}
