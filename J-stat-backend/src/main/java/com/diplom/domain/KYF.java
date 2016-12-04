package com.diplom.domain;

/**
 * Created by Igor on 03.12.2016.
 */
public class KYF {

    private long rowNo;
    private long columnNo;
    private String value;
    private Row row;
    private Column column;

    public KYF() {
    }

    public KYF(long rowNo, long columnNo, String value) {
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.value = value;
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
