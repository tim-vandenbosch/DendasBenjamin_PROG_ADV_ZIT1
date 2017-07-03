package be.pxl.product.servlet;

import be.pxl.product.domain.UserAccount;
import be.pxl.product.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();


        // Check User has logged on
        UserAccount loginedUser = ServletUtil.getLoginedUser(session);


        // Not logged in
        if (loginedUser == null) {

            // Redirect to login page.
            request.getRequestDispatcher("WEB-INF/views/loginView.jsp").forward(request,response);

            return;
        }
        else
        {
            // Store info in request attribute
            request.getSession().setAttribute("loggedInUser",loginedUser);

            // Logined, forward to /WEB-INF/views/userInfoView.jsp
            request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request,response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}