package com.diplom.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
public class Table {
    @Id
    private String id;
    private String name;
    private List<Row> rows;
    private List<Column> columns;
    private List<List<KYF>> kyfMatrix;

    public Table() {
    }

    public Table(String name, List<Row> rows, List<Column> columns, List<List<KYF>> kyfMatrix) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        this.kyfMatrix = kyfMatrix;
    }

    public Table(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
