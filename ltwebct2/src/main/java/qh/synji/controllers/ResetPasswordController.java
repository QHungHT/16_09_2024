package qh.synji.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qh.synji.services.IUserService;
import qh.synji.services.implement.UserServiceImpl;
import qh.synji.models.UserModel;

@WebServlet(urlPatterns = { "/resetpassword" })
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Dịch vụ người dùng để tương tác với cơ sở dữ liệu
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy username và email từ request attributes
		String username = (String) req.getAttribute("username");
		String email = (String) req.getAttribute("email");

		// Xử lý tiếp tục
		req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy username và email từ session, đã được kiểm tra ở ForgotPasswordController
		String username = (String) req.getSession().getAttribute("username");
		String email = (String) req.getSession().getAttribute("email");
		String newPassword = req.getParameter("newpassword");

		// Tìm người dùng dựa trên username
		UserModel user = userService.findByUsername(username);

		// Cập nhật mật khẩu mới
		user.setPassword(newPassword);
		userService.update(user); // Lưu thay đổi vào cơ sở dữ liệu

		// Đặt thông báo thành công
		req.setAttribute("successMessage", "Đặt lại mật khẩu thành công! Vui lòng đăng nhập.");

		// Chuyển hướng đến trang đăng nhập với thông báo
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		// Nếu không tìm thấy người dùng hoặc email không khớp, thông báo lỗi
		req.setAttribute("error", "Tên đăng nhập hoặc email không đúng!");
		req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);

	}
}
