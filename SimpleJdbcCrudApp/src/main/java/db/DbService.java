package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbService {
    private static Connection connection;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    public static Connection getMysqlConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
                connection = DriverManager.getConnection(JDBC_URL,LOGIN,PASSWORD);
            } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
