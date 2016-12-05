package com.diplom.web.controller.trash;

/**
 * Created by Igor on 14.11.2016.
 */
public class MyDro {

    private Hero[] data;

    public MyDro(Hero[] data) {
        this.data = data;
    }

    public Hero[] getData() {
        return data;
    }

    public void setData(Hero[] data) {
        this.data = data;
    }
}
