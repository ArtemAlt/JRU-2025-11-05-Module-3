package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Передаём данные в JSP
        request.setAttribute("message", "Привет из сервлета!");
        request.setAttribute("time", new java.util.Date().toString());

        // Отправляем на JSP (forward, не redirect!)
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}
