
package com.foodmarket.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class SeviceFactory {

    private static SessionFactory sessionFactory;

    private static Configuration config;

    private static Logger log = Logger.getLogger(SeviceFactory.class);

    private static IBaseService serviceBInder[];

    static {
        config = new Configuration();
        config.configure(BaseService.class.getResource("../../../hibernate.cfg.xml"));
        sessionFactory = config.buildSessionFactory();
        log.info("====2=3=build session factory successfully!");
    }

    public synchronized static void initService() {
        if (serviceBInder == null) {
            serviceBInder = new BaseService[20];
            serviceBInder[0] = new TestService();
        }
    }

    public synchronized static void unLoadService() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static Object getService(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("parameter name is null or empty");
        }

        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
