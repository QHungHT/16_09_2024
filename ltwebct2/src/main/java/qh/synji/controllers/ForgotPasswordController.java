package qh.synji.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        // Thực hiện kiểm tra thông tin (ví dụ: tìm người dùng dựa trên username và email)

        // Nếu kiểm tra thành công, chuyển hướng sang trang đặt lại mật khẩu
        resp.sendRedirect(req.getContextPath() + "/views/resetpassword.jsp");
    }
}
