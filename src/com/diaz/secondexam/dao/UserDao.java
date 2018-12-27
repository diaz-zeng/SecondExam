package com.diaz.secondexam.dao;

import com.diaz.secondexam.entity.User;
import com.diaz.secondexam.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户持久化类
 *
 * @author Diaz
 * @since 2018/12/26 15:43
 */
public class UserDao {
    private Session session;

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public boolean save(User user) {
        session = HibernateUtils.getSession();
        try {
            session.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean update(User user) {
        session = HibernateUtils.getSession();
        try {
            session.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除用户信息
     * @param oId
     * @return
     */
    public boolean remove(Integer oId) {
        session = HibernateUtils.getSession();
        try {
            session.delete(session.get(User.class, oId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户信息
     * @param oId
     * @return
     */
    public User get(Integer oId) {
        session = HibernateUtils.getSession();
        User user = null;
        try {
            user = session.get(User.class, oId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 查询全部用户信息(HQL查询)
     * @return
     */
    public List<User> getAll() {
        session = HibernateUtils.getSession();
        List<User> users = new ArrayList<>();
        try {

            Query query = session.createQuery("from User");
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
