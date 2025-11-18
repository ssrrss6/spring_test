package com.zhang.spring6.bean;

import java.util.Arrays;

public class Women {
    String[] name;

    public void setName(String[] name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Women{" +
                "name=" + Arrays.toString(name) +
                '}';
    }
}
