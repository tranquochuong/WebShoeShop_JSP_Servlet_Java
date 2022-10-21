
package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailControl", urlPatterns = "/detail")
public class DetailControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();

        request.setAttribute("detail", p);
        request.setAttribute("listC", listC);
        request.setAttribute("p", last);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Detail.jsp");
        requestDispatcher.forward(request, response);
    }
}
