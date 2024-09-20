package qh.synji.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy phiên làm việc hiện tại
        HttpSession session = req.getSession(false);
        
        // Kiểm tra nếu session tồn tại, thì xóa nó
        if (session != null) {
            session.invalidate(); // Hủy session để đăng xuất người dùng
        }
        
        // Chuyển hướng về trang topbar.jsp
        req.getRequestDispatcher("/views/topbar.jsp").forward(req, resp);
    }
}
