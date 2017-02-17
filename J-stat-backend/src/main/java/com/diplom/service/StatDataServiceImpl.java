package com.diplom.service;

import com.diplom.domain.Table;
import com.diplom.repository.TableRepository;
import com.diplom.service.dto.TableAsStringDto;
import com.diplom.service.dto.TableDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
@Service
public class StatDataServiceImpl implements StatDataService {
    @Autowired
    TableRepository tableRepository;
    @Autowired
    TableDtoConverter tableDtoConverter;

    @Override
    public TableAsStringDto getStatForTable(String tableName) {
        Table table = tableRepository.findByName(tableName);
        //TODO: findByName does not select Column and Row for KYF. I'm not sure that i assign them b4 saving but should check it out
        return tableDtoConverter.convert(table);
    }

    @Override
    public TableAsStringDto[] getAllTables() {
        List<Table> tables = tableRepository.findAll();
        TableAsStringDto[] tableDtos = new TableAsStringDto[tables.size()];
        for (int i = 0; i < tables.size(); i++) {
            tableDtos[i] = tableDtoConverter.convert(tables.get(i));
        }
        return tableDtos;
    }
}
