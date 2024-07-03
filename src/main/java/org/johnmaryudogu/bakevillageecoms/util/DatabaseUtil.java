package org.johnmaryudogu.bakevillageecoms.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/bakevillageDatabase";
        String jdbcUser = "root"; // Replace with your MySQL username
        String jdbcPassword = "Mysql!!!211010"; // Replace with your MySQL password
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }
}

