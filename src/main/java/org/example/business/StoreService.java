package org.example.business;

import org.example.entity.Store;
import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreService {

    private List<Store> stores = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Store register(){
        System.out.print("상점의 이름을 입력해 주세요 : ");
        String name = sc.nextLine();
        System.out.print("상점의 번호를 입력해 주세요 : ");
        String phoneNum = sc.nextLine();
        Store newStore = new Store(name, phoneNum);
        stores.add(newStore);
        System.out.println(name + "상점이 등록되었습니다.");
        return newStore;
    }

    public void registerMenu() {
        System.out.print("메뉴를 등록할 상점의 이름을 입력해 주세요 : ");
        String storeName = sc.nextLine();
        Store findStore = findStore(storeName);
        if (findStore == null) {
            System.out.println("등록되지 않은 상점입니다.");
            return;
        }

        System.out.print("등록할 메뉴의 타입을 입력해주세요 0. 한식 1. 양식 2. 일식 3. 중식 : ");
        int type = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("등록할 메뉴의 이름을 입력해주세요 : ");
        String menuName = sc.nextLine();
        System.out.print("등록할 메뉴의 가격을 입력해주세요 : ");
        int price = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        System.out.print("등록할 메뉴의 수량을 입력해주세요 : ");
        int amount = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        Menu newMenu = new Menu(menuName, price, amount);

        MenuService.registerType(type, newMenu);    // 메뉴 등록
        System.out.println(menuName + "메뉴가 등록되었습니다!");
    }

    public void registerReview(String adminName, String review){
        System.out.print("메뉴를 등록할 상점의 이름을 입력해 주세요 : ");
        String storeName = sc.nextLine();
        Store store = findStore(adminName);
        if (store == null) {
            System.out.println("등록되지 않은 상점입니다.");
            return;
        }
        store.getReviews().add(review);
        System.out.println(store.getName() + "상점의 리뷰가 등록되었습니다.");
    }

    public void printStore(){
        for (int i = 0; i < stores.size(); i++) {
            System.out.println(stores.get(i).getName() + " " + stores.get(i).getPhoneNum());
        }
//        for (Store store : stores) {
//            System.out.println(store.getName());
//        }
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
