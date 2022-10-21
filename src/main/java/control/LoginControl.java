
package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginControl", urlPatterns = "/login")
public class LoginControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("users");
        String password = request.getParameter("pass");
        DAO dao = new DAO();
        Account account = dao.login(username, password);
        if (account == null) {
            request.setAttribute("mess", "Wrong user or pass");

            // cú pháp chuyển trang mang theo dữ liêu --  ở đây là câu thông báo//
            RequestDispatcher requestDispatcher =request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", account);
            session.setMaxInactiveInterval(1000);

            //chuyển trang không cần mang theo dữ liệu//
            response.sendRedirect("/home");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("Login.jsp");
        requestDispatcher.forward(request, response);
    }
}
