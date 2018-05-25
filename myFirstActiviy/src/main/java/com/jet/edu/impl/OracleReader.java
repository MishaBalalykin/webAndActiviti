package com.jet.edu.impl;

import com.jet.edu.api.Reader;
import com.jet.edu.dataSource.DataSourceCreator;
import com.jet.edu.users.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleReader implements Reader {
    private static final String GET_ALL = "SELECT * FROM USERS";
    private DataSource dataSource;

    @Override
    public List<User> readFromOracleBD() {
        dataSource = DataSourceCreator.createDataSource();
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("FIRSTNAME"),
                        resultSet.getString("SURNAME"), resultSet.getString("AGE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
