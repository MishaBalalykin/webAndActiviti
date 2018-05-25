package com.jet.edu.impl;

import com.jet.edu.api.Writer;
import com.jet.edu.context.Context;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.ApplicationContext;

public class BpmnWriter implements JavaDelegate {
    private ApplicationContext context;
    private Writer writer;

    private void createWriter() {
        context = Context.getInsance();
        writer = context.getBean("oracleWriter", OracleWriter.class);
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        createWriter();
        writer.writeToOracleBD(delegateExecution.getVariables());
    }
}
