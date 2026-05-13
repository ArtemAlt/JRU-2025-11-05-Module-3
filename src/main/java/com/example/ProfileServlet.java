package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session.getAttribute("auth-user") == null) {
            resp.sendRedirect("login");
        } else {
            String username = (String) req.getSession().getAttribute("auth-user");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>Добро пожаловать, " + username + "!</h1>");
            out.println("<p>Это защищённая страница, доступная только после входа.</p>");
            out.println("<a href='logout'>Выйти</a>");
            out.println("</body></html>");
        }

    }
}
