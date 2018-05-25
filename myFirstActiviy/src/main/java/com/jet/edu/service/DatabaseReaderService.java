package com.jet.edu.service;

import com.jet.edu.api.Reader;
import com.jet.edu.context.Context;
import com.jet.edu.impl.OracleReader;
import com.jet.edu.users.User;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class DatabaseReaderService {
    private ApplicationContext context;
    private Reader reader;

    private void createReader() {
        context = Context.getInsance();
        reader = context.getBean("oracleReader", OracleReader.class);
    }

    public List<User> readFromBD() {
        createReader();
        return reader.readFromOracleBD();
    }

}
