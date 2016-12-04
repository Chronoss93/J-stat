package com.diplom.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Igor on 03.12.2016.
 */
public class Row {

    @Id
    private long id;
    private Table table;
    private String name;
    private long rowNo;
//    private List<KYF> kyfs;

    public Row(String name, long rowNo) {
        this.name = name;
        this.rowNo = rowNo;
    }

    //for testing
    public Row(Table table, String name, long rowNo) {
        this.table = table;
        this.name = name;
        this.rowNo = rowNo;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRowNo() {
        return rowNo;
    }

    public void setRowNo(long rowNo) {
        this.rowNo = rowNo;
    }

//    public List<KYF> getKyfs() {
//        return kyfs;
//    }
//
//    public void setKyfs(List<KYF> kyfs) {
//        this.kyfs = kyfs;
//    }
}

