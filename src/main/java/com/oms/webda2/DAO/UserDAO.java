package com.oms.webda2.DAO;

import com.oms.webda2.model.User;

import java.sql.SQLException;

public interface UserDAO {
    void insert(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(int userId) throws SQLException;
    void select(int userId) throws SQLException;
}
