package com.diplom.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
public class Table {
    @Id
    private String name;
    private List<Row> rows;
    private List<Column> columns;
    private List<List<KYF>> kyfMatrix;

    public Table() {
    }

    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<List<KYF>> getKyfMatrix() {
        return kyfMatrix;
    }

    public void setKyfMatrix(List<List<KYF>> kyfMatrix) {
        this.kyfMatrix = kyfMatrix;
    }
}
