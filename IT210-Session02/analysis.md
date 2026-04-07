Báo cáo phân tích B3:

1. Tại sao thông báo lỗi đăng nhập phải dùng Request Scope?
Thông báo lỗi đăng nhập (ví dụ: sai username/password) chỉ cần hiển thị trong **một lần request duy nhất** sau khi người dùng submit form.
Request Scope có đặc điểm:
- Chỉ tồn tại trong vòng đời của một HTTP request
- Sau khi response trả về, dữ liệu sẽ tự động bị hủy
Nếu lưu nhầm vào Session Scope:
- Dữ liệu sẽ tồn tại lâu hơn (qua nhiều request)
- Người dùng đăng nhập lại (đúng) vẫn có thể thấy thông báo lỗi cũ
- Gây sai logic hiển thị và trải nghiệm người dùng
2. Tại sao totalViewCount phải dùng Application Scope?
Biến totalViewCount dùng để đếm tổng số lượt xem trang /orders của toàn hệ thống.
Application Scope có đặc điểm:
- Dùng chung cho toàn bộ ứng dụng
- Tất cả user đều truy cập cùng một biến
Nếu dùng Session Scope:
- Mỗi user có một bản riêng của biến
3. Race Condition là gì?
Race Condition là hiện tượng xảy ra khi:
- Nhiều thread (người dùng) cùng truy cập và thay đổi một biến chung
- Các thao tác đọc/ghi không được đồng bộ
4. Phân tích đoạn code lỗi
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
Vấn đề xảy ra khi có nhiều user cùng truy cập
5. Cách phòng tránh Race Condition
synchronized (application) {
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
application.setAttribute("totalViewCount", count + 1);
}