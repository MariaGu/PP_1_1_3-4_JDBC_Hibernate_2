package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("DASHA", "Gubina", (byte) 31);
        userService.saveUser("ROMAN", "Petrova", (byte) 20);
        userService.removeUserById(2);
        userService.saveUser("Ivan", "Kakarekov", (byte) 57);
        userService.saveUser("Roman", "Abramovich", (byte) 42);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers());
        userService.dropUsersTable();
    }
}