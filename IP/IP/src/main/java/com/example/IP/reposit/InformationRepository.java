package com.example.IP.reposit;


import com.example.IP.models.Information;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InformationRepository extends CrudRepository<Information, Long> {
    List<Information> findByStatistic(String statistic);
    List<Information> findByStatisticContaining(String statistic);
}
