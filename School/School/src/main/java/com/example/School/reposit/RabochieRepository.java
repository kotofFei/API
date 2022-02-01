package com.example.School.reposit;

import com.example.School.models.Rabochie;
import com.example.School.models.Teachers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RabochieRepository extends CrudRepository<Rabochie, Long> {
    List<Rabochie> findByRole(String role);
    List<Rabochie> findByName(String name);
    List<Rabochie> findByRoleContaining(String role);
}
