package com.diplom.domain;

/**
 * Created by Igor on 03.12.2016.
 */
public class Column {

    private String name;
    private long columnNo;

    public Column() {
    }

    public Column(String name, long columnNo) {
        this.name = name;
        this.columnNo = columnNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(long columnNo) {
        this.columnNo = columnNo;
    }

}
