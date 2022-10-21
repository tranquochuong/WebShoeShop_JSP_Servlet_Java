package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddAcc", urlPatterns = "/addAcc"   )
public class AddAcc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");


        String pName = request.getParameter("users");
        String pPass = request.getParameter("pass");
        int pisSell = Integer.parseInt(request.getParameter("isSell"));
        int pisAdmin = Integer.parseInt(request.getParameter("isAdmin"));


        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("uses");
        int aid = a.getId();

        DAO dao = new DAO();
        dao.insertAccount(pName, pPass, pisSell, pisAdmin, aid);

        response.sendRedirect("managersAcc");
    }

}

