<%@ page import="com.oms.webda2.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<html>
<head>
    <title>Order Page</title>
</head>
<body>
<%
    User user = null;
    if (request.getSession(false) != null) {
        user = (User) session.getAttribute("user");
    }

    // Retrieve productId from req params
    String productId = request.getParameter("productId");
%>
    <div class="container">
        <h1>Confirm your order</h1>
        <p>Deliver to:</p>
        <p> <%= user.getFirstName() + " " + user.getLastName() %></p>
        <p> <%= user.getAddress() + ", " +  user.getCity() + ", " + user.getProvince() %></p>
        <p> <%= user.getPostalCode() %></p>

        <form action="orderpage" method="post">
            <input type="hidden" name="productId" value="<%= productId %>">
            <input type="submit" value="Confirm Order">
        </form>
    </div>
</body>
</html>
