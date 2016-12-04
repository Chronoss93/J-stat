package com.diplom.web.controller.dto;

import com.diplom.service.dto.OneTableDto;

/**
 * Created by Igor on 13.11.2016.
 */
public class StatDto {

    private OneTableDto data;

    public StatDto(OneTableDto data) {
        this.data = data;
    }

    public OneTableDto getData() {
        return data;
    }

    public void setData(OneTableDto data) {
        this.data = data;
    }
}
