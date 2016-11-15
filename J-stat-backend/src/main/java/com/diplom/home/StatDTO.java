package com.diplom.home;

/**
 * Created by Igor on 12.11.2016.
 */
public class StatDTO {

    private String[][] kyf;
    private String[] rowHeaders;
    private String[] columnHeaders;

    public String[][] getKyf() {
        return kyf;
    }

    public void setKyf(String[][] kyf) {
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


}
