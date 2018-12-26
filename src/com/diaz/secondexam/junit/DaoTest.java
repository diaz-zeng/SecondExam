package com.diaz.secondexam.junit;

import com.diaz.secondexam.utils.HibernateUtils;
import org.junit.Test;

/**
 * @author Diaz
 * @since 2018/12/26 16:54
 */
public class DaoTest {
    @Test
    public void test() {
        System.out.println(HibernateUtils.getSession());
    }
}
