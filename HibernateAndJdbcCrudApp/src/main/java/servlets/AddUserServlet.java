package servlets;

import entities.UserEntity;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService.getInstance().addUser(new UserEntity(req.getParameter("login"), req.getParameter("password")));
        resp.sendRedirect("/admin.jsp");
    }
}
