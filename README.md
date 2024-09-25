# Tích Hợp Thanh Toán PayPal

## Tổng Quan

Dự án này trình bày cách tích hợp xử lý thanh toán PayPal vào một ứng dụng Spring Boot. Nó cho phép người dùng thực hiện thanh toán qua PayPal, xử lý thành công, hủy bỏ và các phản hồi lỗi một cách hiệu quả.

## Tính Năng

- Tạo thanh toán với nhiều phương thức và loại tiền tệ khác nhau
- Xử lý thành công thanh toán, hủy bỏ và lỗi
- Sử dụng SDK của PayPal cho tích hợp REST API

## Công Nghệ Sử Dụng

- Spring Boot
- PayPal REST API SDK
- Lombok
- Thymeleaf để hiển thị giao diện
- Java 21

## Thiết Lập

### Yêu Cầu

- Java 21
- Maven
- Một IDE (như IntelliJ IDEA hoặc Eclipse)

### Bắt Đầu

1. **Clone Repository**

   ```bash
   git clone https://github.com/yourusername/paypal-integration.git
   cd paypal-integration

## Thêm Thư Viện
<dependency>
    <groupId>com.paypal.sdk</groupId>
    <artifactId>rest-api-sdk</artifactId>
    <version>1.14.0</version>
</dependency>

<dependency>
    <groupId>com.paypal.sdk</groupId>
    <artifactId>paypal-core</artifactId>
    <version>1.7.2</version>
</dependency>

## Cấu Hình
paypal.client-id=YOUR_PAYPAL_CLIENT_ID
paypal.client-secret=YOUR_PAYPAL_CLIENT_SECRET
paypal.mode=sandbox

- Lấy client-id và client-secret trong Paypal Developer (Phải tạo tài khoản riêng và chọn vào tài khoản cá nhân)
- Mode nếu chỉ dùng để test hoặc thanh toán không phải thực tế thì dùng sandbox (Nếu thanh toán 1 cách thực tế thì dùng live)
- Lấy accounts trong Sandbox Account và Create Account ra để lấy Accounts test
