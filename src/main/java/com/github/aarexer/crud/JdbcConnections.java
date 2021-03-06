package com.github.aarexer.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Another way to create singleton in java and use it for hold connections
public enum JdbcConnections {
    EMBEDDED_CONNECTION("jdbc:sqlite::resource:crud.db");

    private Connection connection;

    JdbcConnections(String url) {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create database connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
