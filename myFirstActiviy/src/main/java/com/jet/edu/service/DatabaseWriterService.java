package com.jet.edu.service;

import com.jet.edu.processEngine.ProcessEngineCreator;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;

import java.util.Map;

public class DatabaseWriterService {
    private ProcessEngine processEngine;

    public void writeToBD(Map<String, Object> users) {
//        createProcessEngine();
        processEngine = ProcessEngineCreator.getInstance();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("myProcess", users);

    }
}



