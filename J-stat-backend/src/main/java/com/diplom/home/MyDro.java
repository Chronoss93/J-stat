package com.diplom.home;

/**
 * Created by Igor on 14.11.2016.
 */
public class MyDro {
    public MyDro(Hero[] data) {
        this.data = data;
    }

    private Hero[] data;

    public Hero[] getData() {
        return data;
    }

    public void setData(Hero[] data) {
        this.data = data;
    }
}
