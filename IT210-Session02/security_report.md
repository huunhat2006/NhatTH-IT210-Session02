Báo cáo phân tích B2:
1. XSS là gì?
XSS là lỗ hổng bảo mật cho phép kẻ tấn công chèn mã JavaScript độc hại vào nội dung trang web.
Khi dữ liệu đầu vào từ người dùng không được kiểm soát và hiển thị trực tiếp lên HTML, trình duyệt sẽ thực thi đoạn script đó.

2. Vì sao <c:out> an toàn hơn ${}?
<c:out value="${keyword}" />
- Tự động escape các ký tự đặc biệt:
  <  → &lt;
  >  → &gt;
  "  → &quot;
3. <c:if> vs <c:choose>
<c:if>:
- Dùng cho điều kiện đơn giản (1 nhánh)
- Không có else
<c:choose>:
- Giống if - else if - else
- Dùng khi có nhiều điều kiện
Trong bài này:
- Giá vé: có 2 trường hợp → nên dùng <c:choose>
- Vé còn lại: có nhiều điều kiện (0, <10, >=10) → bắt buộc dùng <c:choose>
=> <c:choose> giúp code rõ ràng và đúng logic hơn
4. <c:url> giải quyết vấn đề gì?
Hardcode:
href="/events/1/book"
Khi deploy:
http://localhost:8080/ticketing
thực tế:
http://localhost:8080/events/1/book gây 404
<c:url value="/events/${event.id}/book"/>
http://localhost:8080/ticketing/events/1/book (ĐÚNG)
