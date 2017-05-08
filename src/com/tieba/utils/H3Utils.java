package com.tieba.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class H3Utils {

    private static SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    /**
     * 获得线程绑定的session
     * @return
     */
    public  static Session getCurrentSession(){
        return factory.getCurrentSession();
    }

}
