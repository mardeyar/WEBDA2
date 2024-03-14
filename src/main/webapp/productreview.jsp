<%@ page import="java.util.List" %>
<%@ page import="com.oms.webda2.model.ProductReview" %>
<%@ page import="com.oms.webda2.controller.ProductReviewController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int productId = Integer.parseInt(request.getParameter("productId"));
    List<ProductReview> reviews = new ArrayList<>();
    try {
        ProductReviewController prc = new ProductReviewController();
        reviews = prc.select(productId);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Reviews</title>
</head>
<body>

<div class="container">
    <h1>Product Reviews</h1>
    <% if (!reviews.isEmpty()) { %>
    <% for (ProductReview review : reviews) { %>
    <div class="review">
        <p>Rating: <%= review.getRating() %></p>
        <p>Review Info: <%= review.getReviewInfo() %></p>
    </div>
    <% } %>
    <% } else { %>
    <p>No reviews available for this product.</p>
    <% } %>
</div>

</body>
</html>
