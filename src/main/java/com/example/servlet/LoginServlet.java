package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && (login.equals("user") || login.equals("admin"))
                && password != null && !password.trim().isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        } else {
            request.setAttribute("error", "Invalid login or password. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
