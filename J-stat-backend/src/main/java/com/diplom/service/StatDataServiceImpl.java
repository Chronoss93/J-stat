package com.diplom.service;

import com.diplom.domain.Table;
import com.diplom.repository.TableRepository;
import com.diplom.service.StatDataService;
import com.diplom.service.dto.StatDto;
import com.diplom.service.dto.StatDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 03.12.2016.
 */
@Service
public class StatDataServiceImpl implements StatDataService {
    @Autowired
    TableRepository tableRepository;
    @Autowired
    StatDtoConvertor statDtoConvertor;
    @Override
    public StatDto getStatForTable(String tableId) {
        Table table = tableRepository.getTable(tableId);
        return statDtoConvertor.convert(table);
    }
}
