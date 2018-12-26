package com.diaz.secondexam.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Diaz
 * @since 2018/12/26 19:32
 */
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            Boolean flag = false;
            if(action!=null&&action.length()>0){
                Method[] methods = this.getClass().getMethods();
                for (Method method:methods) {
                    if(method.getName().equals(action)){
                        flag = true;
                        break;
                    }
                }
                this.getClass().getMethod(action,HttpServletRequest.class,HttpServletResponse.class).invoke(this,request,request);
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
}
