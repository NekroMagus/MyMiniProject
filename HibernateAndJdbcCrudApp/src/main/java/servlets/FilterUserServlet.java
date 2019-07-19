package servlets;


import entities.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterUserServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute("role");
        if (session.getAttribute("login") == null) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        if(role == null || role == Role.USER){
            resp.sendRedirect("/index.jsp");
            return;
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
