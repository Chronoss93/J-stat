package com.diplom.web.dto;

import com.diplom.service.dto.TableAsStringDto;

/**
 * Created by Igor on 04.12.2016.
 */
public class TablesWebDto {

    private TableAsStringDto[] data;

    public TablesWebDto(TableAsStringDto[] data) {
        this.data = data;
    }

    public TableAsStringDto[] getData() {
        return data;
    }

    public void setData(TableAsStringDto[] data) {
        this.data = data;
    }
}
