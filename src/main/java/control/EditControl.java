
package control;

import dao.DAO;
import entity.Category;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditControl", urlPatterns = "/edit")
public class EditControl extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("Edit.jsp");
        requestDispatcher.forward(request, response);
}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice = request.getParameter("price");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");
        DAO dao = new DAO();
        dao.editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pid);

        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
        response.sendRedirect("managers");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
