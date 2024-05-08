package com.jeepway.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jeepway.constant.DBConstants;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName(DBConstants.DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DBConstants.CONNECTION_STRING, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
