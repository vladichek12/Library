package com.example.library.dbcontrollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jdbc:postgresql://localhost:5432/library_db";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "vladislavchik123";

    private Connection connection;

    public DBWorker()  {
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
