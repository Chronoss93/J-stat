package com.diplom.service.dto;

/**
 * Created by Igor on 04.12.2016.
 */
public class TableAsStringDto {
    private String tableName;
    private String[] rowHeaders;
    private String[] columnHeaders;
    private String[][] kyf;

    public TableAsStringDto(String tableName, String[] rowHeaders, String[] columnHeaders, String[][] kyf) {
        this.tableName = tableName;
        this.rowHeaders = rowHeaders;
        this.columnHeaders = columnHeaders;
        this.kyf = kyf;
    }

    public String[] getRowHeaders() {
        return rowHeaders;
    }

    public void setRowHeaders(String[] rowHeaders) {
        this.rowHeaders = rowHeaders;
    }

    public String[] getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(String[] columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public String[][] getKyf() {
        return kyf;
    }

    public void setKyf(String[][] kyf) {
        this.kyf = kyf;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
