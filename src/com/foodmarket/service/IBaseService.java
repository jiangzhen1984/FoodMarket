package com.foodmarket.service;

import com.foodmarket.dao.IBaseDao;

import org.hibernate.Session;

/**
 *
 * @author 28851274
 *
 */
public interface IBaseService {

    public Session openSession();

    public void closeSession(Session session);

    public void setSession(Session session);

    public void setDao(IBaseDao dao);

    public IBaseDao getDao();

}
