package com.jet.edu.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
    private static ApplicationContext context;

    public static ApplicationContext getInsance() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("camel-context.xml");
        }
        return context;
    }
}
