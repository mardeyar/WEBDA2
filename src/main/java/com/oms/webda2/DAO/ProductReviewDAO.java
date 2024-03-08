package com.oms.webda2.DAO;

import com.oms.webda2.model.ProductReview;

import java.sql.SQLException;

public interface ProductReviewDAO {
    void insert(ProductReview productReview) throws SQLException;
    void update(ProductReview productReview) throws SQLException;
    void delete(int productReviewId) throws SQLException;
    void select(int productReviewId) throws SQLException;
}
