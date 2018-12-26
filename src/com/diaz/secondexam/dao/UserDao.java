package com.diaz.secondexam.dao;

import com.diaz.secondexam.entity.User;
import com.diaz.secondexam.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz
 * @since 2018/12/26 15:43
 */
public class UserDao {
    private Session session = HibernateUtils.getSession();

    public boolean saveOrUpDate(User user) {
        try {
            session.saveOrUpdate(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(Integer oId) {
        try {
            session.delete(session.get(User.class, oId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User get(Integer oId) {
        User user = null;
        try {
            user = session.get(User.class, oId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAll() {
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
