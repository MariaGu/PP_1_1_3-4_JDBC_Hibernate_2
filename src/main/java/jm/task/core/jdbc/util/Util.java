package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getConnection() throws SQLException {

        String user = "root";
        String password = "Mar666036*";
        String url = "jdbc:mysql://localhost:3306/users";

        return DriverManager.getConnection(url, user, password);
    }

}
