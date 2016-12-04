package com.diplom.repository;

import com.diplom.domain.Column;
import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import com.diplom.domain.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
//@Repository
public class TableRepositoryMock {
    public void persist(Table table) {
        return;
    }

    public Table getTable(String tableId) {
        return constructTable();
    }

    private Table constructTable() {
        Table table = new Table("myTable");
        ArrayList<Row> rows = generateRowsForTable(table);
        ArrayList<Column> columns = generateColumnsForTable(table);
        List<List<KYF>> kyfs = generateKyfAndBindWithRowsColumnsTable(rows, columns, table);
        table.setRows(rows);
        table.setColumns(columns);
        table.setKyfMatrix(kyfs);
        return table;
    }

    private List<List<KYF>> generateKyfAndBindWithRowsColumnsTable(ArrayList<Row> rows, ArrayList<Column> columns, Table table) {
        List<List<KYF>> result = new ArrayList<>();
        for (Row row : rows) {
            List<KYF> kyfRow = new ArrayList<>();
            for (Column column : columns) {
                KYF kyf = new KYF(row.getRowNo(), column.getColumnNo(), row.getRowNo() + " " + column.getColumnNo());
                kyf.setRow(row);
                kyf.setColumn(column);
//                kyf.setTable(table);
                kyfRow.add(kyf);
            }
            result.add(kyfRow);
        }
        return result;
    }

    private ArrayList<Column> generateColumnsForTable(Table table) {
        return new ArrayList<Column>() {{
            add(new Column("col1", 1));
            add(new Column("col2", 2));
        }};
    }

    private ArrayList<Row> generateRowsForTable(Table table) {
        return new ArrayList<Row>() {{
            add(new Row( "row1", 1));
            add(new Row( "row2", 2));
        }};
    }

    ;
}
