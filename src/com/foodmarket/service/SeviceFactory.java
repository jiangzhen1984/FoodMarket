package com.foodmarket.service;

public class SeviceFactory {

    private static IBaseService serviceBInder[];

    public static void initService() {
        serviceBInder = new BaseService[20];
        serviceBInder[0] = new TestService();
    }

    public static void unLoadService() {

    }

    public static Object getService(String name) {
        if(name == null || name.equals("")) {
            throw new RuntimeException("parameter name is null or empty") ;
        }

        return null;
    }


}
