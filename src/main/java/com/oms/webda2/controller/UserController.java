package com.oms.webda2.controller;

import com.oms.webda2.DAO.UserDAO;
import com.oms.webda2.model.User;
import static com.oms.webda2.database.SQLConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController implements UserDAO {
    private static final String INSERT = "INSERT INTO users(first_name, last_name, address, city, province, postal_code, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET ?=? WHERE user_id = ?";
    private static final String DELETE = "DELETE FROM users WHERE user_id = ?";
    private static final String LOGIN = "SELECT email FROM users WHERE email = ? AND password = ?";
    private static final String SELECT = "SELECT * FROM users";

    // Methods from UserDAO
    @Override
    public void insert(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection();
            stmt = connection.prepareStatement(INSERT);

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getCity());
            stmt.setString(5, user.getProvince());
            stmt.setString(6, user.getPostalCode());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL syntax error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Caught exception: " + e.getMessage());
        } finally {
            stmt.close();
            connection.close();
        }
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(int userId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL syntax error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection();
            stmt = connection.prepareStatement(LOGIN);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            stmt.close();
            connection.close();
        }
    }

    @Override
    public List<User> select() throws SQLException {
        List<User> users = new ArrayList<>();
        return users;
    }
}
