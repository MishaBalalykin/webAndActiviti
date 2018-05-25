package com.jet.edu.service;

import com.jet.edu.context.Context;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class DatabaseWriterService {
    private ProcessEngine processEngine;
    private ApplicationContext context;

    private void createProcessEngine() {
        context = Context.getInsance();
        processEngine = context.getBean("processEngine", ProcessEngine.class);
    }

    public void writeToBD(Map<String, Object> users) {
        createProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("myProcess", users);
    }
}



