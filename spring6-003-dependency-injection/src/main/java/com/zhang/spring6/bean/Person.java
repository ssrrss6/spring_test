package com.zhang.spring6.bean;

import java.util.List;

public class Person {
    List<Women> list;

    public void setList(List<Women> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "list=" + list +
                '}';
    }
}
