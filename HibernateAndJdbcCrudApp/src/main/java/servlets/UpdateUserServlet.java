package servlets;

import entities.UserEntity;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = UserService.getInstance().getUserById(req.getParameter("id"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        UserService.getInstance().updateUser(user);
        resp.sendRedirect("/admin.jsp");
    }
}
