package com.jet.web.servlets;

import com.jet.edu.service.DatabaseWriterService;
import com.jet.web.context.Context;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/userAdded")
public class UserAdded extends HttpServlet {
    private ApplicationContext context;
    private DatabaseWriterService dbWriter;

    private void createWriter() {
        context = Context.getInsance();
        dbWriter = context.getBean("writer", DatabaseWriterService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createWriter();
        req.getRequestDispatcher("UserAdded.jsp").forward(req, resp);
        Map<String, Object> users = new HashMap<>();
        users.put("surname", req.getParameter("surname"));
        users.put("name", req.getParameter("name"));
        users.put("age", req.getParameter("age"));
        dbWriter.writeToBD(users);
    }
}
