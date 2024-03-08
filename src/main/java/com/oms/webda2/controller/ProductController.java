package com.oms.webda2.controller;

import com.oms.webda2.DAO.ProductDAO;
import com.oms.webda2.model.Product;

import java.sql.SQLException;

public class ProductController implements ProductDAO {
    private static final String INSERT = "INSERT INTO products(product_name, product_category, product_info, quantity_in_stock, review_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE products SET ? = ? WHERE ? = ?";
    private static final String DELETE = "DELETE FROM products WHERE product_id = ?";
    private static final String SELECT = "SELECT * FROM products";

    // Methods from ProductDAO
    @Override
    public void insert(Product product) throws SQLException {

    }

    @Override
    public void update(Product product) throws SQLException {

    }

    @Override
    public void delete(int productId) throws SQLException {

    }

    @Override
    public void select(int productId) throws SQLException {

    }
}
