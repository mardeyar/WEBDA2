package com.oms.webda2.DAO;

import com.oms.webda2.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void insert(Product product) throws SQLException;
    void update(Product product) throws SQLException;
    void delete(int productId) throws SQLException;
    List<Product> select() throws SQLException;
    List<String> getCategories() throws SQLException;
    List<Product> selectByCategory(String category) throws SQLException;
}
