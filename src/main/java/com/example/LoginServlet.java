package com.example;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final Map<String, String> users = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        users.put("admin","admin");
        users.put("user1","1234");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("""
            <html>
            <body>
                <h1>Вход в систему</h1>
                <form method="post">
                    Логин: <input type="text" name="username"><br>
                    Пароль: <input type="password" name="password"><br>
                    <button type="submit">Войти</button>
                </form>
            </body>
            </html>
        """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (users.containsKey(username) && users.get(username).equals(password)) {
            req.getSession().setAttribute("auth-user", username);
            resp.sendRedirect("profile");
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>Ошибка входа!</h1>");
            out.println("<p>Неверный логин или пароль</p>");
            out.println("<a href='login'>Попробовать снова</a>");
            out.println("</body></html>");
            resp.sendError(403, "Forbidden");
        }
    }
}
