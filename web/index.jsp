<%--
  Created by IntelliJ IDEA.
  User: zly98
  Date: 2018/12/26
  Time: 18:10
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
    <title>Index</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <%String popMsg = (String) session.getAttribute("popMsg");%>
    <%if (popMsg != null && popMsg.length() > 0) {%>
    <script type="text/javascript">
        alert(<%=popMsg%>)
    </script>
    <%}%>
</head>
<body>
<div class="container" style="background-color: azure">
    <%Boolean status = (Boolean) session.getAttribute("status");%>
    <% if (status == null || !status) {%>
    <h1 class="center-block">暂无数据</h1>
    <%} else {%>
    <div class="container-fluid">
        <form id="indexForm" action="#">
            <table class="table table-hover table-striped">
                <caption>用户信息</caption>
                <thead>
                <tr>
                    <td><label>全选</label><input type="checkbox" id="selectAll"/></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td></tr>
                </thead>
            </table>
        </form>
    </div>
    <%}%>
</div>
</body>
</html>