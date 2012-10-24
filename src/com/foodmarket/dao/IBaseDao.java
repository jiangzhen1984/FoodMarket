package com.foodmarket.dao;

import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {

    public  void   update(Object object) ;

    public  Serializable   save(Object object);

    public Object load(Class theClass, Serializable id);

    void   delete(Object object);


    void   delete(Class cls,  Serializable id);

    List query(Query query);

}
