package com.longbow.response.beans;

import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class Person2 {
    //username=zhangsan&password=123456&cellphone=1233456878&
    // address.province=福建省&address.city=莆田市&address.area=荔城区
    // &sex=男&hobby=篮球&hobby=乒乓球&grade=一年级&agreement=on

    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
    private Address address;
    private String sex;
    private String[] hobby;
    private String grade;

    @Override
    public String toString() {
        return "Person2{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", agreement=" + agreement +
                ", address=" + address +
                ", sex='" + sex + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", grade='" + grade + '\'' +
                '}';
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}


