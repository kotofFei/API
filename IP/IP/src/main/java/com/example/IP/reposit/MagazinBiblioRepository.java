package com.example.IP.reposit;

import com.example.IP.models.ElectroSsilki;
import com.example.IP.models.Information;
import com.example.IP.models.MagazinBiblio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MagazinBiblioRepository extends CrudRepository<MagazinBiblio, Long> {

    MagazinBiblio findMagazinBiblioByName(String name);
}
