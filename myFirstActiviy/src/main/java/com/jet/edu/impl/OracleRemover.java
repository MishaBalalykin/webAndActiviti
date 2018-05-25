package com.jet.edu.impl;

import com.jet.edu.api.Remover;
import com.jet.edu.dataSource.DataSourceCreator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleRemover implements Remover {
    private DataSource dataSource;
    private static final String REMOVE_ALL = "TRUNCATE TABLE USERS";

    @Override
    public void readFromOracleBD() {
        dataSource = DataSourceCreator.createDataSource();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ALL)) {
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
