package com.diplom.service.dto;

import com.diplom.domain.Column;
import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import com.diplom.domain.Table;
import com.diplom.web.controller.dto.StatDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 04.12.2016.
 */
@Service
public class StatDtoConvertorImpl implements StatDtoConvertor {

    @Override
    public OneTableDto convert(Table table) {
        List<Row> rows = table.getRows();
        String[] rowArray = rows.stream().map(Row::getName).toArray(String[]::new);
        List<Column> columns = table.getColumns();
        String[] columnArray = columns.stream().map(Column::getName).toArray(String[]::new);

        List<List<KYF>> kyfMatrix = table.getKyfMatrix();
        String[][] kyfs = new String[kyfMatrix.size()][kyfMatrix.get(0).size()];

        for (int i = 0; i < kyfMatrix.size(); i++) {
            kyfs[i] = getOneRowOfKyf(kyfMatrix.get(i));
        }
        return new OneTableDto(table.getName(), rowArray, columnArray, kyfs);
    }

    private String[] getOneRowOfKyf(List<KYF> kyfs) {
        return kyfs.stream().map(KYF::getValue).toArray(String[]::new);

    }
}
