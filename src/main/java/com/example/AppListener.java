package com.example;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletRequestListener {

    public void contextInitialized(ServletContextEvent sce) {

    }
}
