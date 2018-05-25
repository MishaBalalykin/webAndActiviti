package com.jet.edu.api;

import com.jet.edu.users.User;

import java.util.List;

public interface Reader {
    List<User> readFromOracleBD();
}
/*mvn install:install-file -Dfile=C:\Users\mr.balalykin\Downloads\webAndActiviti\myFirstActiviy\target\myFirstActiviy-1.0-SNAPSHOT.jar -DpomFile=C:\Users\mr.balalykin\Downloads\webAndActiviti\myFirstActiviy\pom.xml*/
