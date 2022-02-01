package com.example.School.reposit;

import com.example.School.models.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Students, Long> {
    List<Students> findByCurs(String Curs);
    List<Students> findByFIO(String FIO);
    List<Students> findByCursContaining(String Curs);
}

