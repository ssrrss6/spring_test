package com.longbow.springmvc.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", agreement=" + agreement +
                '}';
    }

    public Person(String username, String password, String cellphone, boolean agreement) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
        this.agreement = agreement;
    }

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
}
