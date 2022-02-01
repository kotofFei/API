package com.example.IP.reposit;


import com.example.IP.models.Nakladnaya;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NakladnayaRepository extends CrudRepository<Nakladnaya, Long> {
    List<Nakladnaya> findByDati(String dati);
    List<Nakladnaya> findByDatiContaining(String dati);
}
