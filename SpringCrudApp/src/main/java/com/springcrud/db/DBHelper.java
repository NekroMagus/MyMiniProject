package com.springcrud.db;

import com.springcrud.model.User;
import org.hibernate.cfg.Configuration;

public final class DBHelper {

    private static DBHelper instance;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    private static Configuration configuration;

    private DBHelper() {
    }

    public Configuration getConfiguration() {
        configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", JDBC_URL);
        configuration.setProperty("hibernate.connection.username", LOGIN);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("show_sql", "false");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }
}
