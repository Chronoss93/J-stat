package com.diplom.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
public class Column {

    @Id
    private String id;
    private Table table;
    private String name;
    private long columnNo;

    public Column() {
    }

    public Column(String name, long columnNo) {
        this.name = name;
        this.columnNo = columnNo;
    }

    //for testing
    public Column(Table table, String name, long columnNo) {
        this.table = table;
        this.name = name;
        this.columnNo = columnNo;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(long columnNo) {
        this.columnNo = columnNo;
    }

//    public List<KYF> getKyfs() {
//        return kyfs;
//    }
//
//    public void setKyfs(List<KYF> kyfs) {
//        this.kyfs = kyfs;
//    }
}
