package com.example.IP.reposit;

import com.example.IP.models.Books;
import com.example.IP.models.Buhgalt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuhgaltRepository extends CrudRepository<Buhgalt, Long> {
    List<Buhgalt> findByMonth(String Month);
    List<Buhgalt> findByMonthContaining(String Month);
}