package com.jet.edu.main;

import com.jet.edu.service.DatabaseReaderService;
import com.jet.edu.service.DatabaseRemoverService;
import com.jet.edu.service.DatabaseWriterService;
import com.jet.edu.service.UserTaskService;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        UserTaskService userTaskService = new UserTaskService();
        userTaskService.startUserTAsk();
        userTaskService.finishProcess();
    }
}
