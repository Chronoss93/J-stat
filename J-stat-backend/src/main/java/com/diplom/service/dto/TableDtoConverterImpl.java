package com.diplom.service.dto;

import com.diplom.domain.Column;
import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import com.diplom.domain.Table;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 04.12.2016.
 */
@Service
public class TableDtoConverterImpl implements TableDtoConverter {

    @Override
    public OneTableDto convert(Table table) {
        List<Row> rows = table.getRows();
        String[] rowArray = rows.stream().map(Row::getName).toArray(String[]::new);
        List<Column> columns = table.getColumns();
        String[] columnArray = columns.stream().map(Column::getName).toArray(String[]::new);

        List<List<KYF>> kyfMatrix = table.getKyfMatrix();
        String[][] kyfs = new String[kyfMatrix.size()][kyfMatrix.get(0).size()];

        for (int i = 0; i < kyfMatrix.size(); i++) {
            kyfs[i] = getOneRowStringKyf(kyfMatrix.get(i));
        }
        return new OneTableDto(table.getName(), rowArray, columnArray, kyfs);
    }

    private String[] getOneRowStringKyf(List<KYF> kyfs) {
        return kyfs.stream().map(KYF::getValue).toArray(String[]::new);

    }
    //move to another class
    public double[] getOneRowDoubleKyf(List<KYF> kyfs) {
        return kyfs.stream().mapToDouble(kyf -> Double.parseDouble(kyf.getValue())).toArray();
    }
}
