<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ include file="header.jsp" %>
<table border="1">
    <tr>
        <th>STT</th><th>Tên</th><th>Phòng</th><th>Lương</th><th>Ngày</th><th>Trạng thái</th><th></th>
    </tr>
    <c:forEach items="${list}" var="e" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td><c:out value="${e.name}"/></td>
            <td>${e.department}</td>
            <td><fmt:formatNumber value="${e.salary}" type="currency"/></td>
            <td><fmt:formatDate value="${e.joinDate}" pattern="dd/MM/yyyy"/></td>
            <td>${e.status}</td>
            <td>
                <a href="<c:url value='/employees/${e.code}'/>">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p>Tổng lương phòng Kỹ thuật: <fmt:formatNumber value="${totalTech}" type="currency"/></p>
<%@ include file="footer.jsp" %>
