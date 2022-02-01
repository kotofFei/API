package com.example.IP.reposit;


import com.example.IP.models.Skidki;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkidkiRepository extends CrudRepository<Skidki, Long> {
    List<Skidki> findByRazmer(String razmer);
}
