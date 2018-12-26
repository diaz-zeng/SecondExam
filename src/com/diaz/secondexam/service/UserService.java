package com.diaz.secondexam.service;

import com.diaz.secondexam.entity.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author Diaz
 * @since 2018/12/26 15:45
 */
public interface UserService {
    /**
     * 添加一个用户
     *
     * @param user 用户对象
     * @return 是否成功
     */
    public boolean addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 删除一个用户
     *
     * @param id 用户id
     * @return 是否成功
     */
    public List<Integer> removeUser(Integer[] id);

    /**
     * 获取一个用户
     *
     * @param id 用户id
     * @return 是否成功
     */
    public User getUser(Integer id);

    /**
     * 获取全部用户
     *
     * @return
     */
    public List<User> getAll();
}