package com.github.walterolivos.core_eng.tema_MySql.Services;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/contactList?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection createConnection() {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            DriverManager.registerDriver(new Driver());
            return connection;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
