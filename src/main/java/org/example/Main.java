package org.example;

import org.example.business.MenuService;
import org.example.business.StoreService;
import org.example.business.UserService;
import org.example.config.DeliveryConfig;
import org.example.entity.Store;
import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        메인에는 안내 정도만 있도록, 그 안내를 통해 클래스로 이동
        */

        StoreService storeService = DeliveryConfig.getStoreService();
        UserService userService = DeliveryConfig.getUserService();
        MenuService menuService = DeliveryConfig.getMenuService();

        storeService.init();
        // 스토어 서비스 객체 생성 - 메인(프로그램 시작점) 내에서 스토어 서비스 안에 있는 것들을 사용
        Scanner sc = new Scanner(System.in); // 입력받을 준비

        while(true){ // 계속 반복..?
            System.out.println();
            System.out.println("Delivery service");
            System.out.println("1. Admin 2. User 9. Exit");
            int num = sc.nextInt(); // 메뉴 선택
            sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
            if (num==1){ // 1. 상점 메뉴
                System.out.println("1. Store register 2. Menu register 3. Store check 4. Menu check 5. Update Menu");
                int storeNum = sc.nextInt(); // 상점 메뉴 -> 메뉴 선택
                sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
                if(storeNum == 1){ // 1. 상점 등록
                    storeService.register();
                } else if (storeNum==2) { // 2. 메뉴 등록
                    storeService.registerMenu();
                } else if (storeNum==3) { // 3. 가게 확인
                    storeService.printStore();
                } else if (storeNum==4) { // 4. 메뉴 확인
                    menuService.printTypeMenu();
                } else if (storeNum == 5) {
                    menuService.updateMenu();
                }
            } else if (num==2) { // 2. 고객 메뉴
                System.out.println("Choose menu");
//                userService.printMenu(); // 메뉴 출력
                menuService.printAll();

                String selectName = sc.nextLine(); // 메뉴 이름 입력

                System.out.println(selectName + " order success! \nenjoy our dishes!");

            } else if(num==9) { // 9. 탈출구
                break;
            }


        }



    }
}