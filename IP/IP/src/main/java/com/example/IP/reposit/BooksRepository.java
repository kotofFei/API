package com.example.IP.reposit;

import com.example.IP.models.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books, Long>{
    List<Books> findByName(String Name);
    List<Books> findByNameContaining(String Name);
}
