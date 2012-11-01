package com.foodmarket.bean;

import com.foodmarket.service.TestService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TestBean {

    private TestService test;

    public TestBean() {
        test = new TestService();
    }


    public String getTest() {
        test.test();
        return "ssss";
    }
}
