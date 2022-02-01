package com.example.IP.reposit;

import com.example.IP.models.Skidki;
import com.example.IP.models.Zal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZalRepository extends CrudRepository<Zal, Long> {
    List<Zal> findByNumber(String number);
    Zal findZalByNumber(String number);
}
