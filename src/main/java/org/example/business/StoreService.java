package org.example.business;

import org.example.entity.Store;
import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreService {

    private List<Store> stores = new ArrayList<>(); // 스토어 타입의 배열, 내부엔 스토어 타입의 객체들이 들어감
    /*
    List<type> objname = new ArrayList<>();
    편리한 리스트...........파이썬 같은..?
    원래 자바는 배열 길이 수정 불가
    */

    Scanner sc = new Scanner(System.in);

    public Store register(){
        System.out.print("Input store name : ");
        String name = sc.nextLine();
        System.out.print("Input store number : ");
        String phoneNum = sc.nextLine();
        Store newStore = new Store(name, phoneNum); // 스토어 인스턴스 생성(생성자)
        stores.add(newStore); // 생성 후 배열에 넣기 l.append()와 비슷?
        System.out.println("'''" + name + "''' Registration Success!");
        return newStore;
    }

    public void registerMenu() {
        System.out.print("Input store name : ");
        String storeName = sc.nextLine();
        Store findStore = findStore(storeName);
        if (findStore == null) {
            System.out.println("No store");
            return;
        }

        System.out.println("Input type of menu 0. Korean 1. English 2. Japanese 3. Chinese");
        int type = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input menu name : ");
        String menuName = sc.nextLine();
        System.out.print("Input menu price : ");
        int price = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("Input the number of menu : ");
        int amount = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        Menu newMenu = new Menu(menuName, price, amount);

        MenuService.registerType(type, newMenu);    // 메뉴 등록
        System.out.println("'''" + menuName + "''' Registration Success!");
    }

    public void printStore(){
        for (int i = 0; i < stores.size(); i++) {
            System.out.println(stores.get(i).getName() + " " + stores.get(i).getPhoneNum());
        }
    }

    public Store findStore(String adminName){
        for(int i = 0; i< stores.size(); i++){
            Store temp = stores.get(i);
            if (temp.getName().equals(adminName)){
                return temp;
            }
        }
        return null;
    }

}
