package com.foodmarket.service;

public class SeviceFactory {

    public static Object getService(String name) {
        if(name == null || name.equals("")) {
            throw new RuntimeException("parameter name is null or empty") ;
        }

        return null;
    }


}
