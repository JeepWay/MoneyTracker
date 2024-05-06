package com.jeepway.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConstants {
    static Properties prop = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String DRIVER_NAME = prop.getProperty("db.driver");
    public static final String DB_HOST = prop.getProperty("db.host");
    public static final String DB_PORT = prop.getProperty("db.port");
    public static final String DB_NAME = prop.getProperty("db.name");
    public static final String DB_USER_NAME = prop.getProperty("db.username");
    public static final String DB_PASSWORD = prop.getProperty("db.password");
    public static final String CONNECTION_STRING = DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
}
