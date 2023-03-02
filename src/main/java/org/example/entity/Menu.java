package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;    // 메뉴의 이름은 유일하다는 전제가 필요 (추후 DB의 주키의 개념)
    private int price;
    private int amount;
    private Type type;

    public Menu(String name, int price, int amount, Type type) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.type = type;
    }

    public static Type intToType(int type){
        if(type==0) return Type.KOREAN;
        else if(type==1) return Type.ENGLISH;
        else if(type==2) return Type.JAPAN;
        else if(type==3) return Type.CHINESE;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
