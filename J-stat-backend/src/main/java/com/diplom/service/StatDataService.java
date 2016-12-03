package com.diplom.service;

import com.diplom.service.dto.StatDto;

/**
 * Created by Igor on 03.12.2016.
 */
public interface StatDataService {

    StatDto getStatForTable(String tableId);
}
