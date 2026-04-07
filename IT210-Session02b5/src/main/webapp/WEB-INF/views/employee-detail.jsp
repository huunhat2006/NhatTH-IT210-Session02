<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="header.jsp" %>
<h3>${emp.name}</h3>
<p>Phòng: ${emp.department}</p>
<c:choose>
  <c:when test="${sessionScope.role == 'hr_manager'}">
    <p>Lương: ${emp.salary}</p>
  </c:when>
  <c:otherwise>
    <p>Lương: ***</p>
  </c:otherwise>
</c:choose>
<a href="<c:url value='/employees'/>">Quay lại</a>
<%@ include file="footer.jsp" %>
