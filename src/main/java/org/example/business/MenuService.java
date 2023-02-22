package org.example.business;

import org.example.entity.Menu;
import org.example.entity.Type;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    public static void registerType(int type, Menu menu) {
        switch (type){
            case 0:
                Type.korean.add(menu);
                break;
            case 1:
                Type.english.add(menu);
                break;
            case 2:
                Type.japan.add(menu);
                break;
            case 3:
                Type.chinese.add(menu);
                break;
            default:
                System.out.println("유효하지 않는 타입입니다.");
        }
    }

    public static void printTypeMenu() {
        System.out.println("확인하고 싶은 타입을 선택해주세요. 0. 한식 1. 양식 2. 일식 3. 중식");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        sc.nextLine();  // console input에 남아있는 \n값 날려주기(문자열 이외 입력받을때 발생)
        switch (type){
            case 0:
                print(Type.korean);
                break;
            case 1:
                print(Type.english);
                break;
            case 2:
                print(Type.japan);
                break;
            case 3:
                print(Type.chinese);
                break;
            default:
                System.out.println("유효하지 않는 타입입니다.");
        }
    }

    public static void print(List<Menu> menus) {
        for (Menu menu : menus) {
            System.out.println(menu.getName());
        }
    }

}
