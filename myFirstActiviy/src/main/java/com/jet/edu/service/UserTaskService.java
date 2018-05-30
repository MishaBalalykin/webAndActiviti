package com.jet.edu.service;

import com.jet.edu.processEngine.ProcessEngineCreator;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import java.util.List;

public class UserTaskService {
    private ProcessEngine processEngine;
    private TaskService taskService;
    private List<Task> taskList;

    private void createProcessEngineAndTask() {
        processEngine = ProcessEngineCreator.getInstance();
        taskService = processEngine.getTaskService();
        taskList = taskService.createTaskQuery().taskAssignee("misha").list();
    }

    public String startUserTAsk() {
        System.out.println("i'm in startUserTAsk");
        createProcessEngineAndTask();
        System.out.println();
        System.out.println();
        System.out.println("processEngine = " + processEngine);
        System.out.println("taskService = " + taskService);
        System.out.println("taskList = " + taskList);
        System.out.println();
        System.out.println();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("userTaskProcess");
        System.out.println("start: "+taskList);
        System.out.println("i'm waiting for button");
        return "i'm waiting for button";
    }

    public void finishProcess(){
//        createProcessEngineAndTask();
        System.out.println("i'm in finishProcess");
        System.out.println("stop: "+taskList);
        System.out.println("task list.size "+ taskList.size());
        System.out.println();
        System.out.println();
        System.out.println("processEngine = " + processEngine);
        System.out.println("taskService = " + taskService);
        System.out.println("taskList = " + taskList);
        System.out.println();
        System.out.println();
        taskService.complete(taskList.get(0).getId());
        System.out.println("task list.size "+ taskList.size());
        System.out.println("i'm out");
    }
}
