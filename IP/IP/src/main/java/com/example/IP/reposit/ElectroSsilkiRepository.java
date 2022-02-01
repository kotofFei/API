package com.example.IP.reposit;

import com.example.IP.models.Directors;
import com.example.IP.models.ElectroSsilki;
import com.example.IP.models.Zal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectroSsilkiRepository extends CrudRepository<ElectroSsilki, Long> {
    List<ElectroSsilki> findBySsilka(String ssilka);
    ElectroSsilki findElectroSsilkisBySsilka(String ssilka);
}
