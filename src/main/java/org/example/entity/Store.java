package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;    // 상점의 이름은 유일하다는 전제 필요 (추후 DB의 주키의 개념)
    private String phoneNum;
    private List<Menu> menuList = new ArrayList<>();

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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
