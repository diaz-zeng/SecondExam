package com.diaz.secondexam.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Diaz
 * @since 2018/12/26 16:03
 */
public class HibernateUtils {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static {
        configuration = new Configuration().configure();
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
