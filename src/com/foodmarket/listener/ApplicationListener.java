package com.foodmarket.listener;

import com.foodmarket.service.SeviceFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            SeviceFactory.initService();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
