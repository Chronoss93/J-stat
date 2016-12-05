package com.diplom.service;

import com.diplom.service.dto.OneTableDto;

/**
 * Created by Igor on 03.12.2016.
 */
public interface StatDataService {

    OneTableDto getStatForTable(String tableName);
}
