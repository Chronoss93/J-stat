package com.diplom.service;

import com.diplom.domain.Table;
import com.diplom.repository.TableRepository;
import com.diplom.service.dto.OneTableDto;
import com.diplom.web.controller.dto.StatDto;
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
    public OneTableDto getStatForTable(String tableName) {
        Table table = tableRepository.findByName(tableName);
        //TODO: findByName does not select Column and Row for KYF. I'm not sure that i assign them b4 saving but should check it out
        return statDtoConvertor.convert(table);
    }
}
