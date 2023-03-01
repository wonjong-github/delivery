package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private String phoneNum;

    public Store(String name, String phoneNum) { // 스토어 생성자
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
