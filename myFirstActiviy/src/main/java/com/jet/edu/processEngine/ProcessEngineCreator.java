package com.jet.edu.processEngine;

import com.jet.edu.context.Context;

import org.activiti.engine.ProcessEngine;

public class ProcessEngineCreator {
    private static ProcessEngine processEngine;

    public static ProcessEngine getInstance(){
        if (processEngine == null){
            processEngine = Context.getInsance().getBean("processEngine", ProcessEngine.class);
        }
        return processEngine;
    }
}
