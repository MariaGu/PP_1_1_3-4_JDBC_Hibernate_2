package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS user (" +
                "id INT auto_increment, " +
                "name VARCHAR(255), " +
                "last_name VARCHAR(255), " +
                "age INT, " +
                "primary key (id))";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS user";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO user (name, last_name, age)" +
                "VALUES ('" + name + "', '" + lastName + "', " + age + ")";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("User  именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE FROM user WHERE id = " + id;
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        String query = "SELECT id, name, last_name, age FROM user ";
        try {
            Statement statement = Util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                byte age = resultSet.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String query = "TRUNCATE user";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
