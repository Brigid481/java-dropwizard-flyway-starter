package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");

            while (resultSet.next()) {
                Systems.out.println(resultSet.getString("Database"))
                databases.add(resultSet.getString("Database"));
            }
            System.out.println("Finished retrieving database names");
        }

        return databases;
    }
}
