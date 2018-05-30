package com.jet.web.servlets.servletsForReadWrateAndRemove;


import com.jet.edu.service.DatabaseReaderService;
import com.jet.edu.users.User;
import com.jet.web.context.Context;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/viewUsers")
public class ViewUsers extends HttpServlet {
    private static List<User> users;
    private ApplicationContext context;
    private DatabaseReaderService dbReader;

    private void createReader() {
        context = Context.getInsance();
        dbReader = context.getBean("reader", DatabaseReaderService.class);
    }

    public static List<User> getUsers() {
        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createReader();
        users = dbReader.readFromBD();
        req.setAttribute("users", users);
        req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);
    }
}
