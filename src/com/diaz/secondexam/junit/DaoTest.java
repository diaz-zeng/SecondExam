package com.diaz.secondexam.junit;

import com.diaz.secondexam.dao.UserDao;
import com.diaz.secondexam.entity.User;
import com.diaz.secondexam.proxy.ServiceProxy;
import com.diaz.secondexam.service.UserService;
import com.diaz.secondexam.service.UserServiceImpl;
import com.diaz.secondexam.utils.HibernateUtils;
import org.junit.Test;

/**
 * @author Diaz
 * @since 2018/12/26 16:54
 */
public class DaoTest {
    @Test
    public void test() {
        UserService userService = ServiceProxy.getProxyInstance(UserServiceImpl.class);
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUsername("test"+i);
            user.setPassword("123");
            user.setGender(i%2==0);
            user.setAge(10+i);
            userService.addUser(user);
        }
    }
}
