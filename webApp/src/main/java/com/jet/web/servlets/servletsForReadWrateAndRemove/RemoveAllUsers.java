package com.jet.web.servlets.servletsForReadWrateAndRemove;

import com.jet.edu.service.DatabaseRemoverService;
import com.jet.web.context.Context;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeUsers")
public class RemoveAllUsers extends HttpServlet {
    private ApplicationContext context;
    private DatabaseRemoverService dbRemover;

    private void createRemover() {
        context = Context.getInsance();
        dbRemover = context.getBean("remover", DatabaseRemoverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createRemover();
        dbRemover.removeFromBD();
        req.getRequestDispatcher("UsersRemoved.jsp").forward(req, resp);
    }
}
