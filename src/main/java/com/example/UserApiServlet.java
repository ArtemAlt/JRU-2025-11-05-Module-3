package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api_v1/user")
public class UserApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        resp.setHeader("My-Custom-Header", "My Custom Header");
        String json = """
                {
                "id": 1,
                "name": "Иван"
                "active": true
                }
                """;
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
