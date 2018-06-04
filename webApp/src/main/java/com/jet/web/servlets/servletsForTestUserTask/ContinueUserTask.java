package com.jet.web.servlets.servletsForTestUserTask;

import com.jet.edu.service.UserTaskService;
import org.springframework.context.ApplicationContext;

import com.jet.web.context.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Continue")
public class ContinueUserTask extends HttpServlet {
    private ApplicationContext context;
    private UserTaskService userTaskService;

    private void createBeans() {
        context = Context.getInsance();
        userTaskService = context.getBean("userTask", UserTaskService.class);
//        userTaskService = new UserTaskService();
        System.out.println("in continue " + userTaskService);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createBeans();
        userTaskService.finishProcess();
        req.getRequestDispatcher("webFormsForTestUserTask/ProcessFinished.html").forward(req, resp);
    }
}
