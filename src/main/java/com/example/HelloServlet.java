package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Мой первый сервлет</title></head>");
        out.println("<body>");
        out.println("<h1>Привет из сервлета!</h1>");
        out.println("<p>Этот ответ сгенерирован Java-кодом</p>");
        out.println("<p>Текущее время: " + new java.util.Date() + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
