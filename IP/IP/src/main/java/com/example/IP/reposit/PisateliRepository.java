package com.example.IP.reposit;


import com.example.IP.models.Pisateli;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PisateliRepository extends CrudRepository<Pisateli, Long> {
    List<Pisateli> findByFIO(String FIO);
    List<Pisateli> findByStaz(String staz);
}
