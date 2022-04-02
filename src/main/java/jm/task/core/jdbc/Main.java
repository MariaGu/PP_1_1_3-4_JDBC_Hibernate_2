package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {

    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Masha", "Gubina", (byte) 31);
        userDaoJDBC.saveUser("Glasha", "Petrova", (byte) 20);
        userDaoJDBC.saveUser("Ivan", "Kakarekov", (byte) 57);
        userDaoJDBC.saveUser("Roman", "Abramovich", (byte) 42);
        userDaoJDBC.getAllUsers().forEach(System.out::println);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}