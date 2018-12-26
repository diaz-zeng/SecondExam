package com.diaz.secondexam.proxy;

import com.diaz.secondexam.utils.HibernateUtils;
import org.hibernate.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 服务层事务代理
 *
 * @author Diaz
 * @since 2018/12/26 16:48
 */
public class ServiceProxy {
    public static Object getProxyInstance(Class clazz) {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Transaction transaction = HibernateUtils.getSession().beginTransaction();
                Object result = null;
                try {
                    result = method.invoke(proxy, args);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    transaction.rollback();
                }
                return null;
            }
        };
    }
}
