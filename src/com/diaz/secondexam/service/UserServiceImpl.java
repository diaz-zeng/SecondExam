package com.diaz.secondexam.service;

import com.diaz.secondexam.dao.UserDao;
import com.diaz.secondexam.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz
 * @since 2018/12/26 16:40
 */
public class UserServiceImpl implements UserService {

    UserDao userDao;

    {
        userDao = new UserDao();
    }

    @Override
    public boolean addUser(User user) {
        return userDao.saveOrUpDate(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.saveOrUpDate(user);
    }

    @Override
    public List<Integer> removeUser(Integer[] id) {
        List<Integer> results = new ArrayList<>();
        for (Integer i : id) {
            if (!userDao.remove(i))
                results.add(i);
        }
        return results;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
