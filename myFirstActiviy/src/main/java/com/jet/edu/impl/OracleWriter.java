package com.jet.edu.impl;

import com.jet.edu.api.Writer;
import com.jet.edu.dataSource.DataSourceCreator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class OracleWriter extends DataSourceCreator implements Writer {
    private static final String INSERT_INTO = "INSERT INTO USERS(FIRSTNAME, SURNAME, AGE) VALUES(?,?,?)";
    private DataSource dataSource;

    @Override
    public void writeToOracleBD(Map users) {
        dataSource = DataSourceCreator.createDataSource();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, String.valueOf(users.get("name")));
            preparedStatement.setString(2, String.valueOf(users.get("surname")));
            preparedStatement.setInt(3, Integer.parseInt(users.get("age").toString()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
