package com.diplom.web.dto;

import com.diplom.service.dto.TableAsStringDto;

/**
 * Created by Igor on 13.11.2016.
 */
public class OneTableWebDto {

    private TableAsStringDto data;

    public OneTableWebDto(TableAsStringDto data) {
        this.data = data;
    }

    public TableAsStringDto getData() {
        return data;
    }

    public void setData(TableAsStringDto data) {
        this.data = data;
    }
}
