package com.example.IP.reposit;

import com.example.IP.models.Rabochie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RabochieRepository extends CrudRepository<Rabochie, Long> {
    List<Rabochie> findByRole(String role);
    List<Rabochie> findByName(String name);
    List<Rabochie> findByRoleContaining(String role);
}
