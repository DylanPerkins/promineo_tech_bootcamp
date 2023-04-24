package recipes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipes.exception.dbException;

public class dbConnection {
    private static final String SCHEMA = "recipes";
    private static final String USER = "recipes";
    private static final String PASSWORD = "recipes";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;

    public static Connection getConnection() {
        String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false",
                HOST, PORT, SCHEMA, USER, PASSWORD);
        
        System.out.println("Connecting with url: " + url);

        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connected to database");
            return conn;
        } catch (SQLException e) {
            throw new dbException("Error connecting to database", e);
        }
    }
}
