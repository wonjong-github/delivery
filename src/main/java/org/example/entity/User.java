package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Menu> selectedMenu = new ArrayList<>();

    public List<Menu> getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(List<Menu> selectedMenu) {
        this.selectedMenu = selectedMenu;
    }
}
