package com.oms.webda2.controller;

import com.oms.webda2.DAO.ProductReviewDAO;
import com.oms.webda2.model.ProductReview;

import java.sql.SQLException;

public class ProductReviewController implements ProductReviewDAO {
    private static final String INSERT = "INSERT INTO product_reviews(product_id, review_info, rating) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE product_reviews SET ? = ? WHERE product_review_id = ?";
    private static final String DELETE = "DELETE FROM product_reviews WHERE product_review_id = ?";
    private static final String SELECT = "SELECT * FROM product_reviews";

    // Methods from ProductReviewDAO
    @Override
    public void insert(ProductReview productReview) throws SQLException {

    }

    @Override
    public void update(ProductReview productReview) throws SQLException {

    }

    @Override
    public void delete(int productReview) throws SQLException {

    }

    @Override
    public void select(int productReview) throws SQLException {

    }
}
