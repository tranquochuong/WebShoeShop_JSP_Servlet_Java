
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

@WebServlet(name = "SearchControl", urlPatterns = "/search")
public class SearchControl extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request doc duoc tieng viet
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");//giay chay bo
        DAO dao = new DAO();
        List<Product> list = dao.searchByName(txtSearch);
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();
        
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("p", last);

        // chữ mình nhập vào chính là value cua input nên muoon giu  lại chu tren ô input thi minh can day txtshearch len value cuia input
        request.setAttribute("txtS", txtSearch);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("Home.jsp");
        requestDispatcher.forward(request, response);
    }


}
