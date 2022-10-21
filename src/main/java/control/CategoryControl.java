
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

@WebServlet(name = "CategoryControl", urlPatterns = "/category")
public class CategoryControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("cid");
        //da lay dc category id ve roi
        DAO dao = new DAO();
        List<Product> list = dao.getProductByCID(cateID);
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();
        
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("p", last);
        request.setAttribute("tag", cateID);

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("Home.jsp");
        requestDispatcher.forward(request, response);
    }
}
