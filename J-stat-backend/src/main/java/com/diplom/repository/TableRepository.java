package com.diplom.repository;

import com.diplom.domain.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Igor on 03.12.2016.
 */
public interface TableRepository extends MongoRepository<Table, Long> {

    Table findByName(String name);
    Table save(Table table);
//    void persist(Table table);
//
//    Table getTable(String tableId);
}