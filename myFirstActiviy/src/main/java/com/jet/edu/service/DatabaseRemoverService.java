package com.jet.edu.service;

import com.jet.edu.api.Remover;
import com.jet.edu.context.Context;
import com.jet.edu.impl.OracleRemover;
import org.springframework.context.ApplicationContext;

public class DatabaseRemoverService {
    private ApplicationContext context;
    private Remover remover;

    private void createRemover() {
        context = Context.getInsance();
        remover = context.getBean("oracleRemover", OracleRemover.class);
    }

    public void removeFromBD() {
        createRemover();
        remover.readFromOracleBD();
    }
}
