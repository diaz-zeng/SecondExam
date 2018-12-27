package com.diaz.secondexam.proxy;

import com.diaz.secondexam.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.Proxy;

/**
 * 服务层事务代理
 *
 * @author Diaz
 * @since 2018/12/26 16:48
 */
public class ServiceProxy {
    public static <T> T getProxyInstance(Class clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
            Session session = HibernateUtils.getSession();
            Transaction transaction =null;
            Object result = null;
            try {
                transaction = session.beginTransaction();
                result = method.invoke(clazz.newInstance(), args);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
            return result;
        });
    }
}
