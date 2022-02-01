package com.example.BDPractice.reposit;

import com.example.BDPractice.models.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Long> {

}

