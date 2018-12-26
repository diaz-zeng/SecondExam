package com.diaz.secondexam.controller;

import com.diaz.secondexam.proxy.ServiceProxy;
import com.diaz.secondexam.service.UserService;
import com.diaz.secondexam.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Diaz
 * @since 2018/12/26 20:00
 */
@WebServlet("/userAction")
public class UserActionServlet extends AjaxServlet {
    private UserService userService = (UserService) ServiceProxy.getProxyInstance(UserServiceImpl.class);

    public void removeUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String[] sid = request.getParameterValues("id");
            Integer[] id = new Integer[sid.length];
            PrintWriter writer = response.getWriter();
            for (int i = 0; i < sid.length; i++) {
                id[i] = Integer.parseInt(sid[i]);
                List<Integer> failed = userService.removeUser(id);
                if (failed.size() > 0) {
                    writer.write("用户删除失败，可能不存在:");
                    writer.flush();
                } else {
                    writer.write("用户删除成功:");
                    writer.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
