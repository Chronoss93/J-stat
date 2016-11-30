package com.diplom.home;

/**
 * Created by Igor on 13.11.2016.
 */
public class RealDTO {
    private StatDTO data;

    public RealDTO(StatDTO data) {
        this.data = data;
    }

    public StatDTO getData() {
        return data;
    }

    public void setData(StatDTO data) {
        this.data = data;
    }
}
