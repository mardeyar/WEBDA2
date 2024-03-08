package com.oms.webda2.DAO;

import com.oms.webda2.model.Order;

import java.sql.SQLException;

public interface OrderDAO {
    void insert(Order order) throws SQLException;
    void update(Order order) throws SQLException;
    void delete(int orderId) throws SQLException;
    void select(int orderId) throws SQLException;
}
