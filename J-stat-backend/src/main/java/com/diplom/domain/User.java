package com.diplom.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Igor on 04.12.2016.
 */
public class User {
    @Id
    private String id;
    private List<Table> tableList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }
}
