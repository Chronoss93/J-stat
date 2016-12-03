package com.diplom.repository;

import com.diplom.domain.Table;

/**
 * Created by Igor on 03.12.2016.
 */
public interface TableRepository {
    void persist(Table table);

    Table getTable(String tableId);
}