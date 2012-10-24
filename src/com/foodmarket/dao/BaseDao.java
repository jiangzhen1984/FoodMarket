
package com.foodmarket.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDao implements IBaseDao {

    enum CheckTypeEnum {
        CHECK_TRANSACTION,
    }

    protected Session session;

    public BaseDao() {
    }

    private void checkSession(CheckTypeEnum cascade) {
        if (session == null) {
            throw new RuntimeException("Session is null");
        }

        if (!session.isOpen() || !session.isConnected()) {
            throw new RuntimeException("session is not opened or is not connected");
        }

        if (cascade == CheckTypeEnum.CHECK_TRANSACTION && session.getTenantIdentifier() == null) {
            throw new RuntimeException("Doesn't in transaction, please begin transaction first!");
        }
    }

    public void update(Object object) {
        checkSession(CheckTypeEnum.CHECK_TRANSACTION);
        session.update(object);
    }

    public Serializable save(Object object) {
        checkSession(CheckTypeEnum.CHECK_TRANSACTION);
        return session.save(object);
    }

    public Object load(Class theClass, Serializable id) {
        checkSession(null);
        return session.get(theClass, id);
    }

    public void delete(Object object) {
        session.delete(object);
    }

    public void delete(Class cls, Serializable id) {
        checkSession(CheckTypeEnum.CHECK_TRANSACTION);
        session.delete(load(cls, id));
    }

    public List query(Query query) {
        return null;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
