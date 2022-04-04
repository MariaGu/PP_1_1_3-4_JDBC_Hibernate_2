package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static String user = "root";
    private static String password = "Mar666036*";
    private static String url = "jdbc:mysql://localhost:3306/users";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

//    private static Connection connection;
//
//    private Util(){}
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null){
//            return connection = DriverManager.getConnection(url, user, password);
//        }
//        return connection;
//    }

}
