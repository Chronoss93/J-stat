package com.diplom.service;

import com.diplom.domain.Column;
import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import com.diplom.domain.Table;
import com.diplom.repository.TableRepository;
import com.diplom.repository.TableRepositoryImpl;
import com.diplom.service.CsvDataHandler;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronoss on 24.10.15.
 */
@Service
public class CsvDataHandlerImpl implements CsvDataHandler {

    private static final String DELIMITER = ";";
    private TableRepository tableRepository;

    @Override
    public void handleMessage(String text) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(text));

        String line = br.readLine();

        String[] firstRow = line.split(DELIMITER);
        //TODO: make 0 element as rowType in future
        String tableName = firstRow[0];


        List<Column> columns = new ArrayList<>(firstRow.length - 1);

        for (int columnNo = 1; columnNo < firstRow.length; columnNo++) {
            Column column = new Column(firstRow[columnNo], columnNo);
            columns.add(column);
        }
        //construct Row's and KYF's
        List<Row> rows = new ArrayList<>();
        List<List<KYF>> kyfMatrix = new ArrayList<>();
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
        Table table = constructTable(tableName, rows, columns, kyfMatrix);

        tableRepository.persist(table);
        System.out.println("construct finished");
    }

    private Table constructTable(String tableName, List<Row> rows, List<Column> columns, List<List<KYF>> kyfMatrix) {
        return new Table(tableName, rows, columns, kyfMatrix);
    }

}
