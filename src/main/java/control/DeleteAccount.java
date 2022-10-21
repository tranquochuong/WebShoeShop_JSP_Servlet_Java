
package control;

import dao.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteAccount", urlPatterns = {"/deleteAccount"})
public class DeleteAccount extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String aid = request.getParameter("pid");
        DAO dao = new DAO();
        dao.deleteAccount(aid);
        response.sendRedirect("managersAcc");
    }

}
