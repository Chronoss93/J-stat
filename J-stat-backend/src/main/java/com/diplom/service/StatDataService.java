package com.diplom.service;

import com.diplom.service.dto.OneTableDto;
import com.diplom.web.controller.dto.StatDto;

/**
 * Created by Igor on 03.12.2016.
 */
public interface StatDataService {

    OneTableDto getStatForTable(String tableName);
}
