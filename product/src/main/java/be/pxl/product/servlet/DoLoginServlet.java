package be.pxl.product.servlet;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.UserAccount;
import be.pxl.product.service.ProductService;
import be.pxl.product.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService service = new ProductService();
    public DoLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        // for the "Remember me" field, use ServletUtil class

        boolean hasError = false;
        String errorString = null;

        // test is username and password are not null and string lengths are > 0
        if(username != null && password != null && username.length() > 0 && password.length() >0)
        {
            // If no error
            // Store user information in Session, use ServletUtil class
            // And redirect to userInfo page.

            UserAccount user = service.findUser(username,password);
            ServletUtil.storeLoginedUser(request.getSession(),user);
            response.sendRedirect("userInfo");
        }
        else
        {
            // If error, forward to /WEB-INF/views/login.jsp

            hasError = true;
            errorString = "Gelieve correcte credentials in te geven.";
            request.getSession().setAttribute("errorString",errorString);
            request.getSession().setAttribute("hasError",hasError);
            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request,response);
        }







    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}