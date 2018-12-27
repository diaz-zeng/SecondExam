package com.diaz.secondexam.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 *
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

    /**
     * 获取当前线程session，如果没有可用创建一个，提交事务后自动关闭
     *
     * @return
     */
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
