package com.oms.webda2.controller;

import com.oms.webda2.DAO.ProductDAO;
import com.oms.webda2.database.SQLConnection;
import com.oms.webda2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductController implements ProductDAO {
    private static final String INSERT = "INSERT INTO products(product_name, product_category, product_info, quantity_in_stock, product_image) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE products SET ? = ? WHERE ? = ?";
    private static final String DELETE = "DELETE FROM products WHERE product_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM products";
    private static final String SELECT_CATEGORY = "SELECT DISTINCT product_category FROM products";
    private static final String SELECT_BY_CATEGORY = "SELECT * FROM products WHERE product_category = ?";

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
    public List<Product> select() throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<>();

        try {
            connection = SQLConnection.getConnection();
            stmt = connection.prepareStatement(SELECT_ALL);
            resultSet = stmt.executeQuery();

            // Add products to list while there is a 'next product'
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("product_name"),
                        resultSet.getString("product_category"),
                        resultSet.getString("product_info"),
                        resultSet.getInt("quantity_in_stock"),
                        resultSet.getString("product_image")
                ));
            }
        } catch (Exception e) {
            System.err.println("Exception in execution: " + e.getMessage());
        } finally {
            if (resultSet != null) resultSet.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return products;
    }

    @Override
    public List<String> getCategories() throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        List<String> categories = new ArrayList<>();

        try {
            connection = SQLConnection.getConnection();
            stmt = connection.prepareStatement(SELECT_CATEGORY);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String category = resultSet.getString("product_category");
                categories.add(category);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (resultSet != null) resultSet.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return categories;
    }

    @Override
    public List<Product> selectByCategory(String category) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<>();

        try {
            connection = SQLConnection.getConnection();
            stmt = connection.prepareStatement(SELECT_BY_CATEGORY);
            stmt.setString(1, category);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("product_name"),
                        resultSet.getString("product_category"),
                        resultSet.getString("product_info"),
                        resultSet.getInt("quantity_in_stock"),
                        resultSet.getString("product_image")
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return products;
    }
}
