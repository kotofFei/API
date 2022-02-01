package com.example.IP.reposit;



import com.example.IP.models.Zdanie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZdanieRepository extends CrudRepository<Zdanie, Long> {
    List<Zdanie> findByItazi(String Itazi);
}
