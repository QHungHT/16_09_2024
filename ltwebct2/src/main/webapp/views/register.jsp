<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo tài khoản mới</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 300px;
            margin: 0 auto;
        }
        .input-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .input-group-addon {
            padding: 10px;
            background-color: #f1f1f1;
            border: 1px solid #ccc;
            border-right: none;
            color: #555;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-left: none;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .alert {
            color: red;
            margin-bottom: 10px;
        }
        .footer {
            margin-top: 20px;
            text-align: center;
        }
        .footer a {
            color: #007bff;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>

    <form action="register" method="post">
        <!-- Tên đăng nhập -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" class="form-control" placeholder="Tên đăng nhập" name="username">
        </div>

        <!-- Họ tên -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" class="form-control" placeholder="Họ tên" name="fullname">
        </div>

        <!-- Email -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
            <input type="email" class="form-control" placeholder="Nhập Email" name="email">
        </div>

        <!-- Số điện thoại -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
            <input type="tel" class="form-control" placeholder="Số điện thoại" name="phone">
        </div>

        <!-- Mật khẩu -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input type="password" class="form-control" placeholder="Mật khẩu" name="password">
        </div>

        <!-- Nhập lại mật khẩu -->
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" name="confirmPassword">
        </div>

        <!-- Nút đăng ký -->
        <button type="submit" class="btn">Tạo tài khoản</button>

    </form>

    <!-- Đã có tài khoản -->
    <div class="footer">
        <p>Nếu bạn đã có tài khoản? <a href="login">Đăng nhập</a></p>
    </div>
</div>

</body>
</html>
