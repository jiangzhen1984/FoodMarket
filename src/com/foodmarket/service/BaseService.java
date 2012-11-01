package com.foodmarket.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.BootstrapServiceRegistryImpl;
import org.jboss.logging.Logger;

public abstract class  BaseService implements IBaseService {

    private static SessionFactory sessionFactory;

    private static Configuration config;

    private static Logger log=Logger.getLogger(BaseService.class);

    static {
        config = new Configuration();
        config.configure(BaseService.class.getResource("../../../hibernate.cfg.xml"));
        sessionFactory = config.buildSessionFactory(new BootstrapServiceRegistryImpl());
        log.info("======build session factory successfully!");
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void setSession(Session session) {

    }


}
