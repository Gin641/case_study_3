<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name
  Date: 6/29/2020
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<center>
    <H1>Đăng nhập</H1>
    <form method="post">
        <label >email</label>
        <input type="text" name="email"><br>
        <label >pass</label>
        <input type="password" name="pass"><br>
        <input type="submit" value="Đăng nhập">
        <c:if test="${requestScope['message']!=null}">
            <span style="color: red" class="message">${requestScope["message"]}</span>
        </c:if>
    </form>
    <a href="/student?action=create">Đăng ký</a> <br>
</center>

</body>
</html>
