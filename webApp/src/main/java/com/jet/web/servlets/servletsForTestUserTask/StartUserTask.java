package com.jet.web.servlets.servletsForTestUserTask;

import com.jet.edu.service.UserTaskService;
import com.jet.web.context.Context;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/startBPM")
public class StartUserTask extends HttpServlet {
    private ApplicationContext context;
    private UserTaskService userTaskService;

    private void createBeans() {
        context = Context.getInsance();
        userTaskService = context.getBean("userTask", UserTaskService.class);
//        userTaskService = new UserTaskService();
//        System.out.println("userTaskService = " + userTaskService);
        System.out.println("in start " + userTaskService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createBeans();
        System.out.println("i'm hear");
        if (userTaskService.startUserTAsk().equalsIgnoreCase("i'm waiting for button")){
            System.out.println("111111111111111111111111111111111");
            req.getRequestDispatcher("webFormsForTestUserTask/ProcessStarted.html").forward(req, resp);
            //req.getRequestDispatcher("webFormsForTestUserTask/twist.html").forward(req, resp);
        }
        System.out.println("and now hear");
    }
}
