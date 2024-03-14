package com.oms.webda2.DAO;

import com.oms.webda2.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void insert(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(int userId) throws SQLException;
    User getUserSessionInfo(String email) throws SQLException;
    boolean login(String email, String password) throws SQLException;
    List<User> select() throws SQLException;
}
