package org.example;

import org.example.business.MenuService;
import org.example.business.StoreService;
import org.example.entity.Store;
import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("안녕하세요 배달 서비스입니다.");
            System.out.println("1. 상점 메뉴 2. 고객 메뉴 9. 종료");
            int num = sc.nextInt();
            sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
            if (num==1){
                System.out.println("1. 상점 등록 2. 메뉴 등록 3. 가게 확인 4. 메뉴 확인");
                int storeNum = sc.nextInt();
                sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
                if(storeNum == 1){
                    storeService.register();
                } else if (storeNum==2) {
                    storeService.registerMenu();
                } else if (storeNum==3) {
                    storeService.printStore();
                } else if (storeNum==4) {
                    MenuService.printTypeMenu();
                }
            } else if (num==2) {

            } else {
                break;
            }


        }



    }
}