package com.diplom.service.dto;

import com.diplom.domain.Table;

/**
 * Created by Igor on 04.12.2016.
 */
public interface TableDtoConverter {

    TableAsStringDto convert(Table table);
}
