package be.pxl.product.servlet;

import be.pxl.product.domain.Product;
import be.pxl.product.dao.DAOUtil;
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

@WebServlet("/doCreateProduct")
public class DoCreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService service = new ProductService();
    public DoCreateProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request to create a product
        // store the product
        // if an error occurs show the error on the page you came from
        // if no error occurred and the product was stored, show the list of products

        String code =request.getParameter("code");
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if(code == null || code == "" || name == null || name == "" || price == null || price == "")
        {
            request.setAttribute("error","Gelieve alle velden in te vullen");
            request.getRequestDispatcher("WEB-INF/views/createProductView.jsp").forward(request,response);
        }
        else
        {
            Product productObject = new Product();
            productObject.setCode(code);
            productObject.setName(name);
            productObject.setPrice(Integer.parseInt(price));
            service.insertProduct(productObject);
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