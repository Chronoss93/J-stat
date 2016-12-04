package com.diplom.service;

import com.diplom.domain.Column;
import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import com.diplom.domain.Table;
import com.diplom.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

//import com.diplom.repository.TableRepositoryMock;

/**
 * Created by chronoss on 24.10.15.
 */
@Service
public class CsvDataHandlerImpl implements CsvDataHandler {

    private static final String DELIMITER = ";";
    @Autowired
    private TableRepository tableRepository;

    @Override
    public void handleMessage(String text) throws IOException {
        Table table = new Table();

        ejectDataFromText(text, table);
        tableRepository.save(table);

        System.out.println("construct finished");
    }

    private void ejectDataFromText(String text, Table table) throws IOException {

        BufferedReader textReader = new BufferedReader(new StringReader(text));
        String line = textReader.readLine();
        String[] firstRow = line.split(DELIMITER);
        String tableName = firstRow[0];

        List<Column> columns = new ArrayList<>();
        List<Row> rows = new ArrayList<>();
        List<List<KYF>> kyfMatrix = new ArrayList<>();

        ejectColumns(firstRow, columns);
        ejectRowsAndKyfs(textReader, rows, kyfMatrix);

        fillTable(table, tableName, rows, columns, kyfMatrix);
    }

    private void ejectRowsAndKyfs(BufferedReader br, List<Row> rows, List<List<KYF>> kyfMatrix) throws IOException {
        String line;
        for (int rowNo = 1; (line = br.readLine()) != null; rowNo++) {
            String[] statisticRowString = line.split(DELIMITER);

            Row row = new Row(statisticRowString[0], rowNo);
            rows.add(row);

            ArrayList<KYF> rowKyf = new ArrayList<>();
            for (int columnNo = 1; columnNo < statisticRowString.length; columnNo++) {
                KYF kyf = new KYF(rowNo, columnNo, statisticRowString[columnNo]);
                rowKyf.add(kyf);
            }
            kyfMatrix.add(rowKyf);
        }
    }

    private void ejectColumns(String[] firstRow, List<Column> columns) {
        for (int columnNo = 1; columnNo < firstRow.length; columnNo++) {
            Column column = new Column(firstRow[columnNo], columnNo);
            columns.add(column);
        }
    }


    private void fillTable(Table table, String tableName, List<Row> rows, List<Column> columns, List<List<KYF>> kyfMatrix) {
        table.setName(tableName);
        table.setRows(rows);
        table.setColumns(columns);
        table.setKyfMatrix(kyfMatrix);
    }

}
