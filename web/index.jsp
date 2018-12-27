<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.diaz.secondexam.entity.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <%String popMsg = (String) session.getAttribute("popMsg");%>
    <%if (popMsg != null && popMsg.length() > 0) {%>
    <script type="text/javascript">
        alert(<%=popMsg%>)
    </script>
    <%}%>
</head>
<body>
<div class="container" style="background-color: azure">

    <div class="container-fluid">
        <form id="indexForm" action="#">
            <table class="table table-hover table-striped table-bordered">
                <caption class="h3">用户信息</caption>
                <thead>
                <tr>
                    <td><label><b>全选</b></label><input type="checkbox" id="selectAll"/></td>
                    <td><label><b>用户名</b></label></td>
                    <td><label><b>密码</b></label></td>
                    <td><label><b>年龄</b></label></td>
                    <td><label><b>性别</b></label></td>
                    <td><label><b>修改</b></label></td>
                </tr>
                </thead>
                <%Boolean status = (Boolean) session.getAttribute("status");%>
                <% if (status == null || !status) {%>
                <b class="center-block h2">暂无数据</b>
                <%} else {%>

                <tbody>
                <%List<User> users = (List<User>) session.getAttribute("users");%>
                <%
                    for (User user : users) {%>
                <tr>
                    <td><input type="checkbox" name="id" value="<%=user.getId()%>"></td>
                    <td><%=user.getUsername()%>
                    </td>
                    <td><%=user.getPassword()%>
                    </td>
                    <td><%=user.getAge()%>
                    </td>
                    <td><%=(user.getGender() ? "男" : "女")%>
                    </td>
                    <td>
                        <button class="btn-primary" type="button" onclick="update(<%=user.getId()%>)"><b>修改</b></button>
                    </td>
                </tr>
                <%}%>
                </tbody>

                <%}%>
            </table>
            <div class="container-fluid">
                <button class="btn-warning" type="button" onclick="onFormSubmit()"><b>删除</b></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>