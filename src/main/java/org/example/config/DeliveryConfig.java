package org.example.config;

import org.example.business.MenuService;
import org.example.business.StoreService;
import org.example.business.UserService;
import org.example.init.Init;

/**
 * 서비스 객체들은 Delivery서비스내에서 반드시 하나만 존재해야만 한다.
 * 여러 개 객체가 존재하게 된다면 메뉴, 상점을 관리하는 리스트의 종류가 여러개가 된다는 뜻이기 때문에 여러개 생성되면 안된다.
 * 그러므로 DeliveryConfig라는 클래스를 통해 서비스 객체를 하나만 만들도록 하고 필요한 경우 꺼내쓰도록 한다.
 * 추후 싱글톤(Singleton)이라는 개념으로 이해할 수 있을 것이다.
 */
public class DeliveryConfig {
    private static MenuService menuService = new MenuService();
    private static StoreService storeService = new StoreService(menuService);
    private static UserService userService = new UserService(menuService);

    public static MenuService getMenuService() {
        return menuService;
    }

    public static StoreService getStoreService() {
        return storeService;
    }

    public static UserService getUserService() {
        return userService;
    }
}
