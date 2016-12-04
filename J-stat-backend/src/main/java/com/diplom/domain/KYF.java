package com.diplom.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by Igor on 03.12.2016.
 */
public class KYF {

    @Id
    private String id;
    private long rowNo;
    private long columnNo;
    private String value;
    private Row row;
    private Column column;
    private Table table;

    public KYF() {
    }

    public KYF(long rowNo, long columnNo, String value) {
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public long getRowNo() {
        return rowNo;
    }

    public void setRowNo(long rowNo) {
        this.rowNo = rowNo;
    }

    public long getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(long columnNo) {
        this.columnNo = columnNo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
