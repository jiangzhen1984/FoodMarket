package com.foodmarket.service;

import com.foodmarket.dao.IBaseDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.BootstrapServiceRegistryImpl;

public abstract class BaseService implements IBaseService {

    private static SessionFactory sessionFactory;

    private static Configuration config;

    protected IBaseDao dao;

    static {
        config = new Configuration();
        sessionFactory = config.buildSessionFactory(new BootstrapServiceRegistryImpl());
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void setSession(Session session) {

    }

    public void setDao(IBaseDao dao) {
        this.dao = dao;
    }

    public IBaseDao getDao() {
        return dao;
    }

}
