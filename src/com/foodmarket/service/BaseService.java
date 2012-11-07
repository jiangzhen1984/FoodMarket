package com.foodmarket.service;


import org.hibernate.Session;
import org.jboss.logging.Logger;

import com.foodmarket.service.SeviceFactory;


public abstract class  BaseService implements IBaseService {

    private static ThreadLocal<Session> session = new ThreadLocal<Session>();

    private  Logger log = Logger.getLogger(this.getClass());

    public Session openSession() {
        Session sess= SeviceFactory.getSessionFactory().openSession();
        session.set(sess);
        return sess;
    }


    public void closeSession() {
        Session sess =  session.get();
        if (sess != null) {
            sess.close();
        } else {
            log.warn(" session is not can't find session in thread local:"+ Thread.currentThread());
        }
    }

    public void setSession(Session session) {

    }


}
