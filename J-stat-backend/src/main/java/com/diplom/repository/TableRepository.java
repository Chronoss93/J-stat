package com.diplom.repository;

import com.diplom.domain.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
public interface TableRepository extends MongoRepository<Table, String> {

    Table findByName(String name);

    Table save(Table s);

    @Override
    List<Table> findAll();

}