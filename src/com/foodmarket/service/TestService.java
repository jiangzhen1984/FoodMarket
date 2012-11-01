package com.foodmarket.service;

import org.hibernate.Session;
import org.jboss.logging.Logger;

public class TestService extends BaseService {

    private Logger log = Logger.getLogger(TestService.class);
    public void test() {
        Session sess = this.openSession();
            log.info("=============opensession:"+sess.isConnected());
            if(sess.isConnected()) {
                sess.close();
            }
    }

}
