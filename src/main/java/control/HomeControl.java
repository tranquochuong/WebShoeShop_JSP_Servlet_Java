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

@WebServlet(name ="HomeControl", urlPatterns = {"/home",""})
public class HomeControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();
        

        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("p", last);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
        requestDispatcher.forward(request, response);
    }
}
