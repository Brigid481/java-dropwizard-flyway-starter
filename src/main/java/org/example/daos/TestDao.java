package org.example.daos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:RegexpSingleline"})
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            long start = System.currentTimeMillis();
            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");


            System.out.println("Retrieving database names");

            long end = System.currentTimeMillis();

            System.out.println(
                    "Time to execute in milliseconds:" + (end - start));


            while (resultSet.next()) {
                System.out.println(resultSet.getString("Database"));
                databases.add(resultSet.getString("Database"));
            }
            System.out.println("Finished retrieving database names");
        }

        return databases;
    }
}
