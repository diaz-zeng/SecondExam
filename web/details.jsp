<%@ page import="com.diaz.secondexam.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: zly98
  Date: 2018/12/26
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/details.js"></script>
</head>
<body>
<div class="container" style="background-color: azure">
    <h3>用户信息修改</h3>
    <%User user = (User) session.getAttribute("user");%>
    <%
        if (user == null) {
            user = new User();
        }
    %>
    <div class="container-fluid">
        <form accept-charset="UTF-8" id="detailsForm" action="/userView?doWhat=update" method="post">
            <input type="hidden" name="id" value="<%=user.getId()%>">
            <table class="table table-striped table-bordered table-hover">
                <tr>
                    <td>
                        <div class="form-group"><label for="username" class="form-control"><b>用户名</b></label></div>
                    </td>
                    <td>
                        <div class="form-group"><input id="username" name="username" type="text" class="form-control"
                                                       required value="<%=user.getUsername()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group"><label for="password" class="form-control"><b>密码</b></label></div>
                    </td>
                    <td>
                        <div class="form-group"><input id="password" name="password" type="text" class="form-control"
                                                       required value="<%=user.getPassword()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group"><label for="age" class="form-control"><b>年龄</b></label></div>
                    </td>
                    <td>
                        <div class="form-group"><input id="age" name="age" type="number" max="100" min="1" class="form-control"
                                                       required value="<%=user.getAge()%>">
                        </div>
                    </td>
                </tr>
                <tr><td>
                    <div class="form-group"><label class="form-control"><b>性别</b></label></div>
                </td>
                    <td>
                        <div class="form-group container-fluid">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="male" value="男" required>男
                            </label>

                            <label class="radio-inline">
                                <input type="radio" name="gender" id="female" value="女" required>女
                            </label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="form-group">

                            <button class="btn-primary" id="btnSubmit" type="submit"><b>提交修改</b></button>
                            <button class="btn-success" id="btnSave" type="button" onclick="submitToSave()"><b>注册新用户</b></button>
                            <button class="btn-warning" id="btnBack" type="button" onclick="window.location.href='userView?doWhat=getAll'">
                                <b>返回</b>
                            </button>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>