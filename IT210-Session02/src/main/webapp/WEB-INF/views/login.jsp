<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Đăng nhập hệ thống</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required />
    <br/><br/>
    <label>Password:</label>
    <input type="password" name="password" required />
    <br/><br/>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color:red;">
            ${error}
    </p>
</c:if>
</body>
</html>
