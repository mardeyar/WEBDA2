package com.oms.webda2.DAO;

import com.oms.webda2.model.Product;

import java.sql.SQLException;

public interface ProductDAO {
    void insert(Product product) throws SQLException;
    void update(Product product) throws SQLException;
    void delete(int productId) throws SQLException;
    void select(int productId) throws SQLException;
}
