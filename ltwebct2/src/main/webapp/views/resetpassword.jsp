<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt lại mật khẩu</title>
</head>
<body>
	<h2>Đặt lại mật khẩu</h2>

	<!-- Hiển thị thông báo lỗi nếu có -->
	<c:if test="${not empty errorMessage}">
		<div style="color: red;">
			<strong>${errorMessage}</strong>
		</div>
	</c:if>
	
    <!-- Hiển thị thông báo thành công nếu có -->
    <c:if test="${not empty successMessage}">
        <div style="color: green;">
            <strong>${successMessage}</strong>
        </div>
    </c:if>
	
	<form action="${pageContext.request.contextPath}/resetpassword"
		method="post">
		<label for="newpassword">Mật khẩu mới:</label><br> <input
			type="password" id="newpassword" name="newpassword" required><br>
		<br> <label for="confirmnewpassword">Nhập lại mật khẩu
			mới:</label><br> <input type="password" id="confirmnewpassword"
			name="confirmnewpassword" required><br>
		<br>

		<button type="submit">Đặt lại mật khẩu</button>
	</form>
</body>
</html>
