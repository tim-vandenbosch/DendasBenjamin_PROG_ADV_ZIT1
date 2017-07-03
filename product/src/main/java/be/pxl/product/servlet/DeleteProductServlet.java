package be.pxl.product.servlet;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.Product;
import be.pxl.product.service.ProductService;
import be.pxl.product.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService service = new ProductService();
    public DeleteProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // if an exception is thrown handle it carefully using "errorString" to notify error on view
        // get product code to delete for deleting product
        String code = request.getParameter("code");
        if(code == null || code == "")
        {
            String error = "Code niet gevonden";
            request.setAttribute("error",error);
            request.getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp").forward(request,response);
        }
        else
        {
            // if no exception is thrown show your product list
            service.deleteProduct(code);
            response.sendRedirect("productList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}