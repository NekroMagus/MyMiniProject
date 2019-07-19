package servlets;

import entities.UserEntity;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserEntity user = UserService.getInstance().getUserByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        session.setAttribute("role", user.getRole());

        resp.sendRedirect("/user.jsp");
    }
}
