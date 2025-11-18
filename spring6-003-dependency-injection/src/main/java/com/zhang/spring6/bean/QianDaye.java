package com.zhang.spring6.bean;

import java.util.Arrays;

public class QianDaye {
    private String[] hobby;
    private Women[] women;

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setWomen(Women[] women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "QianDaye{" +
                "hobby=" + Arrays.toString(hobby) +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
