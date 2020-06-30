<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name
  Date: 6/30/2020
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="student?action=home">List All Student</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="name" value="<c:out value='${student.name}' />"/>
            </c:if>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value='<c:out value="${student.name}" />'
                    />
                </td>
            </tr>
            <tr>
                <th>Student Password:</th>
                <td>
                    <input type="password" name="pass" size="45"
                           value='<c:out value="${student.pass}" />'
                    />
                </td>
            </tr>
            <tr>
                <th>Student Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value='<c:out value="${student.phone}" />'
                    />
                </td>
            </tr>
            <tr>
                <th>Student Birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value='<c:out value="${student.birthday}" />'
                    />
                </td>
            </tr>
            <tr>
                <th>Student Sex:</th>
                <td>
                    <input type="text" name="sex" size="45"
                           value='<c:out value="${student.sex}" />'
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Cập nhật"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
