<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name
  Date: 6/27/2020
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>listStudent</title>
</head>
<body>
<h1>
    <a href="/student?action=edit&id=${requestScope.id} ">Edit</a></h1>
<center>
    <h1>Student Management</h1>
</center>
<center>
    <h3>Xin chào : ${requestScope.name}</h3>
    <form action="/student?action=search" method="post">
        <input type="text" name="search">
        <input type="submit" value="search">
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Student</h2></caption>
        <tr>
            <th>Name</th>
            <th>Giới tính</th>
            <th>Kết bạn</th>
        </tr>
        <c:forEach var="student" items = "${students}">
            <tr>
                <td><c:out value="${student.name}"></c:out></td>
                <td><c:out value="${student.sex}"></c:out></td>
                <td>
                    <a href="/student?action=add">add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
