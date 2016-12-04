package com.diplom.service.dto;

import com.diplom.domain.Table;
import com.diplom.web.controller.dto.StatDto;

/**
 * Created by Igor on 04.12.2016.
 */
public interface StatDtoConvertor {

    OneTableDto convert(Table table);
}
