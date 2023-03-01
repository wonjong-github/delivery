package org.example.business;

import java.util.List;
import java.util.Scanner;
import org.example.entity.Menu;
import org.example.entity.Type;
import org.example.entity.User;

public class UserService {
    Scanner sc = new Scanner(System.in);
    public static void printMenu() {
        System.out.println("0. Korean");
        MenuService.print(Type.korean);
        System.out.println("1. English");
        MenuService.print(Type.english);
        System.out.println("2. Japanese");
        MenuService.print(Type.japan);
        System.out.println("3. Chinese");
        MenuService.print(Type.chinese);

        System.out.print("choice! >>>>");
    }

    public static void printDetail(String selectName){

    }


}
