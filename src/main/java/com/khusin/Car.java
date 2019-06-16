package com.khusin;

import java.io.Serializable;

/**
 * Created by sinchan on 07/09/17.
 */
public class Car  implements Serializable{

    private int length;
    private int height;
    private String color;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
