package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerAccountControl", urlPatterns = "/managersAcc")
public class ManagerAccountControl extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("uses");
        int id = a.getId();
        DAO dao = new DAO();
        List<Account> accountList = dao.getAllAccount();
        request.setAttribute("listAcc", accountList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManagerAccount.jsp");
        requestDispatcher.forward(request, response);
    }
}