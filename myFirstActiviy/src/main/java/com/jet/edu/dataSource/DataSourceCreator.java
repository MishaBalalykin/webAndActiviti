package com.jet.edu.dataSource;

import com.jet.edu.context.Context;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

public class DataSourceCreator {
    private static ApplicationContext context;

    public static DataSource createDataSource() {
        context = Context.getInsance();
        return context.getBean("dataSource", DataSource.class);
    }

}
