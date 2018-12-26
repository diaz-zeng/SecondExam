package com.diaz.secondexam.controller;

import com.diaz.secondexam.entity.User;
import com.diaz.secondexam.proxy.ServiceProxy;
import com.diaz.secondexam.service.UserService;
import com.diaz.secondexam.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Diaz
 * @since 2018/12/26 15:46
 */
@WebServlet("/userServlet")
public class UserViewServlet extends BaseServlet {
    private UserService userService = (UserService) ServiceProxy.getProxyInstance(UserServiceImpl.class);

    public String getAll(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<User> users = userService.getAll();
        if (users != null && users.size() > 0) {
            session.setAttribute("status", true);
            session.setAttribute("users", users);
        } else {
            session.setAttribute("status", false);
        }
        return "/index.jsp";
    }

    public String removeUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String[] sid = request.getParameterValues("id");
            Integer[] id = new Integer[sid.length];
            StringBuilder results = new StringBuilder();
            PrintWriter writer = response.getWriter();
            for (int i = 0; i < sid.length; i++) {
                id[i] = Integer.parseInt(sid[i]);
                List<Integer> failed = userService.removeUser(id);
                if (failed.size() > 0) {
                    results.append("下列用户删除失败，可能不存在:");
                    for (Integer j : failed) {
                        results.append(j.toString() + ";");
                    }
                    session.setAttribute("popMsg", results.toString());
                } else {
                    session.setAttribute("popMsg", "删除成功");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/index.jsp";
    }

    public String getDetails(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUser(id);
        if (user != null) {
            session.setAttribute("user", user);
            return "details.jsp";
        } else {
            session.setAttribute("popMsg", "该用户不存在");
            return "index.jsp";
        }
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            Integer age = Integer.parseInt(request.getParameter("age"));
            Boolean gender = request.getParameter("gender").equals("男") ? true : false;
            userService.update(new User(id, name, password, age, gender));
            session.setAttribute("popMsg", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("popMsg", "更新失败");
        }
        return "index.jsp";
    }
}
