<%@ page import="com.oms.webda2.controller.ProductController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oms.webda2.model.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/product.css">
    <title>Products</title>
</head>
<body>
    <h1>Browse our selection</h1>

    <div class="container">
        <%-- Dropdown list to select categories dynamically --%>
        <select id="category" onchange="filterProduct()">
            <option>Select Category</option>
            <option value="">All categories</option>
            <%
                List<String> categories = null;
                try {
                    ProductController pc = new ProductController();
                    categories = pc.getCategories();
                } catch (SQLException e) {
                    System.err.println("SQL syntax error: " + e.getMessage());
                }
                if (categories != null) {
                    for (String category : categories) {
            %>
            <option value="<%= category %>"><%= category %></option>
            <%
                    }
                }
            %>
        </select>

        <%
            ProductController pc = new ProductController();
            List<Product> products;
            String categoryFilter = request.getParameter("category");
            try {
                if (categoryFilter != null && !categoryFilter.isEmpty()) {
                    products = pc.selectByCategory(categoryFilter);
                } else {
                    products = pc.select();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Display this block of text if there are no products available
            if (products.isEmpty()) {
        %>
        <p>No products available at this time</p>
        <%
            } else {
                for (Product product : products) {
        %>
        <div class="product-card">
            <img id="product-img" src="<%= product.getProductImage() %>" alt="<%= product.getProductName() %>">
            <div class="product-card-body">
                <h2><%= product.getProductName()%></h2>
                <p><%= product.getProductCategory()%></p>
                <p><%= product.getProductInfo()%></p>
                <p><%= product.getQuantityInStock()%> in stock</p>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</body>
</html>

<script>
    function filterProduct() {
        const category = document.getElementById("category").value;

        if (category === "all") {
            window.location.href = "products.jsp";
        }
        window.location.href = "products.jsp?category=" + category;
    }
</script>
