package com.example.view;

import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//Model
public class UserViewService {

    public PrintWriter createView(User user, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Привет, " + user.getName() + "!</h1>");
        out.println("</body>");
        out.println("</html>");
        return out;
    }

    public void createUserView(User user, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/"+ user.getName() + ".jsp").forward(req, resp);
    }
    //DDD
}
