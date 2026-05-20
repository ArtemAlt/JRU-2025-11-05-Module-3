package com.example.controller;

import com.example.models.User;
import com.example.models.UserService;
import com.example.view.UserViewService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    UserService userService = new UserService();
    UserViewService userViewService = new UserViewService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        User userById = userService.findUserById(id);
        userViewService.createView(userById, resp);

        /*
        repository
        steamApi() filter
        valid()
        return html;
         */
    }
}
