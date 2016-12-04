package com.diplom.domain;

/**
 * Created by Igor on 03.12.2016.
 */
public class Row {

    private String name;
    private long rowNo;

    public Row() {
    }

    public Row(String name, long rowNo) {
        this.name = name;
        this.rowNo = rowNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRowNo() {
        return rowNo;
    }

    public void setRowNo(long rowNo) {
        this.rowNo = rowNo;
    }
}

