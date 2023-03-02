package org.example.business;

import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private List<Menu> menuList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Menu registerMenu() {
        System.out.println("Input type of menu 0. Korean 1. English 2. Japanese 3. Chinese");
        int typeNum = sc.nextInt();
        Type type = Menu.intToType(typeNum);
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input menu name : ");
        String menuName = sc.nextLine();
        System.out.print("Input menu price : ");
        int price = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input the number of menu : ");
        int amount = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        Menu newMenu = new Menu(menuName, price, amount, type);
        menuList.add(newMenu);
        System.out.println("'''" + menuName + "''' Registration Success!");
        return newMenu;
    }

    public void printTypeMenu() {
        System.out.println("Select Type! 0. Korean 1. English 2. Japanese 3. Chinese");
        int typeNum = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        Type type = Menu.intToType(typeNum);
        for (Menu menu : menuList) {
            if(menu.getType()==type){
                System.out.println(menu.getName());
            }
        }
    }

    public void updateMenu(){
        System.out.println("please input to update Menu name");
        String menuName = sc.nextLine();
        Menu findMenu = find(menuName);
        if(findMenu==null){
            System.out.println("invalid Menu name");
            return;
        }

        System.out.println("Input type of menu 0. Korean 1. English 2. Japanese 3. Chinese");
        int typeNum = sc.nextInt();
        Type type = Menu.intToType(typeNum);
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input menu name : ");
        String newMenuName = sc.nextLine();
        System.out.print("Input menu price : ");
        int price = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input the number of menu : ");
        int amount = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)

        findMenu.setType(type);
        findMenu.setName(newMenuName);
        findMenu.setPrice(price);
        findMenu.setAmount(amount);

        System.out.println("Update Complete!");
    }

    public Menu find(String name){
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public void printAll(){
        for (Menu menu : menuList) {
            System.out.print(menu.getName() + ", ");
        }
    }


}
