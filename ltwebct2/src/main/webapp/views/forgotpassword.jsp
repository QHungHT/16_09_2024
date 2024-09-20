<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
</head>
<body>
    <h2>Quên mật khẩu</h2>

    <!-- Form để người dùng nhập username và email -->
    <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
        <label for="username">Tên đăng nhập:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="email">Địa chỉ Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <!-- Nút xác nhận -->
        <button type="submit">Xác nhận</button>
    </form>
</body>
</html>
