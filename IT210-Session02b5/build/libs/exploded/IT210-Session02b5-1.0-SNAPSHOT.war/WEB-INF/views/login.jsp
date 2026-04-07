<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form method="post" action="<c:url value='/login'/>">
  <input name="username"/>
  <input name="password" type="password"/>
  <button>Login</button>
</form>

<c:if test="${not empty errorMessage}">
  <p style="color:red">${errorMessage}</p>
</c:if>