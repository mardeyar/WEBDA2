package com.oms.webda2.controller;

import com.oms.webda2.DAO.OrderDAO;
import com.oms.webda2.model.Order;

import java.sql.SQLException;

public class OrderController implements OrderDAO {
    private static final String INSERT = "INSERT INTO orders(product_id, user_id) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE orders SET ? = ? WHERE order_id = ?";
    private static final String DELETE = "DELETE FROM orders WHERE order_id = ?";
    private static final String SELECT = "SELECT * FROM orders";

    // Methods from OrderDAO
    @Override
    public void insert(Order order) throws SQLException {

    }

    @Override
    public void update(Order order) throws SQLException {

    }

    @Override
    public void delete(int orderId) throws SQLException {

    }

    @Override
    public void select(int orderId) throws SQLException {

    }
}
