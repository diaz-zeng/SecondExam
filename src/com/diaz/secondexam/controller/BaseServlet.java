package com.diaz.secondexam.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	/**
	 * 当浏览器发送请求是把对应的方法名发送过来 应为UserServlet继承service先进行方法匹配 通过反射 然后执行对应方法
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// request.setCharacterEncoding("UTF-8");
			String doWhat = request.getParameter("doWhat");
			if (doWhat == null || doWhat.length() == 0) {
				doWhat = "zidong";
			}
			Method[] methods = this.getClass().getMethods();
			boolean flag = false;
			for (Method m : methods) {
				if (m.getName().equals(doWhat)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				doWhat = "index";
			}
			// 获取目标方法
			Method method = this.getClass().getMethod(doWhat, HttpServletRequest.class, HttpServletResponse.class);
			// 目标servlet返回的内部跳转路径 调用目标方法
			String path = (String) method.invoke(this, request, response);
			if (path != null) {
				// 内部跳转
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/index.jsp";
	}
}