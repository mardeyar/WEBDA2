package com.oms.webda2.controller;

import com.oms.webda2.DAO.UserDAO;
import com.oms.webda2.model.User;
import static com.oms.webda2.database.SQLConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController implements UserDAO {
    private static final String INSERT = "INSERT INTO users(first_name, last_name, civic, street, city, province, postal_code, user_name, password, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET ?=? WHERE user_id = ?";
    private static final String DELETE = "DELETE FROM users WHERE user_id = ?";
    private static final String SELECT = "SELECT * FROM users";

    // Methods from UserDAO
    @Override
    public void insert(User user) throws SQLException {

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
    public void select(int userId) throws SQLException {

    }
}
