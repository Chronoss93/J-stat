package com.diplom.web.dto;

import com.diplom.service.dto.OneTableDto;

/**
 * Created by Igor on 04.12.2016.
 */
public class TableArrayDto {
    private OneTableDto[] data;

    public TableArrayDto(OneTableDto[] data) {
        this.data = data;
    }

    public OneTableDto[] getData() {
        return data;
    }

    public void setData(OneTableDto[] data) {
        this.data = data;
    }
}
