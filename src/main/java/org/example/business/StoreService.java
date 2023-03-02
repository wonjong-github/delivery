package org.example.business;

import org.example.config.DeliveryConfig;
import org.example.entity.Store;
import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreService {

    private List<Store> stores = new ArrayList<>(); // 스토어 타입의 배열, 내부엔 스토어 타입의 객체들이 들어감

    private MenuService menuService;

    public StoreService(MenuService menuService) {
        this.menuService = menuService;
    }

    // 초기 예시인 값을 미리 넣어주는 함수 (필요없는 영역)
    public void init() {
        Store pizzaHut = new Store("A", "1234-1234");
        Store korean = new Store("B", "1029-1934");
        stores.add(pizzaHut);
        stores.add(korean);
    }

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

    /**
     * 1. 상점을 찾는다.
     * 2. 새로운 메뉴를 등록한다. (다른 상점이어도 메뉴는 달라야함. 설계상 어쩔수없음. 만일 메뉴 이름 중복을 허용하고 싶다면 Menu클래스에 key가 될만한 변수가 필요)
     * 3. 메뉴를 상점에 등록한다.
     */
    public void registerMenu() {
        System.out.print("Input store name : ");
        String storeName = sc.nextLine();
        Store findStore = findStore(storeName);
        if (findStore == null) {
            System.out.println("No store");
            return;
        }
        Menu menu = menuService.registerMenu();
        findStore.getMenuList().add(menu);
        System.out.println("Store " + findStore.getName() + " register " + menu.getName());
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
