package com.jet.edu.main;

import com.jet.edu.service.DatabaseReaderService;
import com.jet.edu.service.DatabaseRemoverService;
import com.jet.edu.service.DatabaseWriterService;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        DatabaseReaderService databaseReaderService = new DatabaseReaderService();
        System.out.println(databaseReaderService.readFromBD());
        DatabaseRemoverService databaseRemoverService = new DatabaseRemoverService();
        databaseRemoverService.removeFromBD();
        System.out.println(databaseReaderService.readFromBD());
        DatabaseWriterService databaseWriterService = new DatabaseWriterService();
        HashMap<String, Object> map = new HashMap<>();
        map.put("surname", "balalykin");
        map.put("name", "misha");
        map.put("age", 22);
        databaseWriterService.writeToBD(map);
        System.out.println(databaseReaderService.readFromBD());
    }
}
