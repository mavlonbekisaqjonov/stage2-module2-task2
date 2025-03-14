package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LocalDateTime timeInit = LocalDateTime.now();
        sce.getServletContext().setAttribute("servletTimeInit", timeInit);
        System.out.println("Context initialized at: " + timeInit);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is being destroyed.");
    }
}
