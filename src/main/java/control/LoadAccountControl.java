package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoadAccountControl", urlPatterns = "/loadAccount")
public class LoadAccountControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("aid");
        DAO dao = new DAO();
        List<Account> account = dao.getAccountByCID(id);

        request.setAttribute("listAcc", account);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Edit.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String pUsers = request.getParameter("users");
        String pPass = request.getParameter("pass");
        int pisSell = Integer.parseInt(request.getParameter("isSell"));
        int pisAdmin = Integer.parseInt(request.getParameter("isAdmin"));

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("uses");
        int sid = a.getId();

        DAO dao = new DAO();
        dao.insertAccount( pUsers, pPass, pisSell, pisAdmin, sid);
        try {
            response.sendRedirect("managersAcc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
