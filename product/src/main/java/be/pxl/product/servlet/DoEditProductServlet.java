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

@WebServlet("/doEditProduct")
public class DoEditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService service = new ProductService();
    public DoEditProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name= request.getParameter("name");
        String price = request.getParameter("price");
        String code = request.getParameter("code");
        Product productObject = new Product();
        productObject.setCode(code);
        productObject.setName(name);
        productObject.setPrice(Integer.parseInt(price));
        service.updateProduct(productObject);

        response.sendRedirect("productList");

        // get all parameters from the request
        // update the product
        // on error return to the page you came from with the error
        // else show the product list containing the updated product


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}