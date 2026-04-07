<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 4/7/2026
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Báo cáo điểm</title>
</head>
<body>
<h1>${reportTitle}</h1>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>

    <c:forEach items="${studentList}" var="sv" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td><c:out value="${sv.fullName}" /></td>
            <td>${sv.score}</td>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%--PHẦN 1 — PHÂN TÍCH LOGIC--%>

<%--+----+------------------------------------------+---------------------------+-------------------------------------------------------------%>
<%--| #  | Vị trí                                   | Loại vấn đề              | Mô tả hậu quả                                               |--%>
<%--| 1  | <%! private int requestCounter = 0; %>   | Race condition           | Biến dùng chung nhiều request → không thread-safe           |--%>
<%--|    |                                          |                          | Dữ liệu sai khi nhiều user truy cập                         |--%>
<%--| 2  | <% lấy dữ liệu từ request %>             | Vi phạm Thin View        | JSP chứa Java logic → khó bảo trì, sai mô hình MVC          |--%>
<%--| 3  | for + if/else trong JSP                  | Logic trong View         | Xử lý nghiệp vụ trong View → khó tái sử dụng                |--%>
<%--| 4  | <%= sv.getFullName() %>                  | XSS                      | Không escape dữ liệu → có thể bị chèn script độc hại        |--%>
<%--| 5  | <%= sv.getScore()%>;                     | Lỗi cú pháp              | Dư dấu ; → hiển thị sai                                     |--%>
<%--| 6  | <!-- comment -->                         | Sai loại comment         | Bị gửi xuống client → lộ thông tin nội bộ                   |--%>
<%--| 7  | <%= ... %>                               | Cú pháp cũ               | Không dùng EL → code khó đọc, không chuẩn MVC               |--%>
<%--+----+------------------------------------------+---------------------------+-------------------------------------------------------------%>

