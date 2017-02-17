package com.diplom.service;

import com.diplom.service.dto.TableAsStringDto;

/**
 * Created by Igor on 03.12.2016.
 */
public interface StatDataService {

    TableAsStringDto getStatForTable(String tableName);

    TableAsStringDto[] getAllTables();
}
