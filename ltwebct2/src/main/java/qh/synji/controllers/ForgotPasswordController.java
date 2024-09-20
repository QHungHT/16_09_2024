package qh.synji.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qh.synji.models.UserModel;
import qh.synji.services.IUserService;
import qh.synji.services.implement.UserServiceImpl;

@WebServlet(urlPatterns = { "/forgotpassword" })
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy dữ liệu từ form
		String username = req.getParameter("username");
		String email = req.getParameter("email");

		UserModel user = service.findByUsername(username);
		if (user != null && email.equals(user.getEmail())) {
			// Nếu username và email hợp lệ, chuyển sang trang đặt lại mật khẩu
			 // Lưu username và email vào session
		    req.getSession().setAttribute("username", username);
		    req.getSession().setAttribute("email", email);
			resp.sendRedirect(req.getContextPath() + "/views/resetpassword.jsp");
		} else {
			// Nếu thông tin không hợp lệ, hiển thị thông báo lỗi
			req.setAttribute("errorMessage", "Username hoặc Email không đúng!");
			req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
		}
	}
}
