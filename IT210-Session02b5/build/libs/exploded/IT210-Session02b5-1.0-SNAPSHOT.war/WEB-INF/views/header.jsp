<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div>
    Xin chào: ${sessionScope.loggedUser}

    <c:if test="${sessionScope.role == 'hr_manager'}">
        | Quản lý
    </c:if>
    | <a href="<c:url value='/logout'/>">Logout</a>
</div>
<hr/>
