<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reviews</title>
</head>
<body>
    <div class="container">
        <h1>Write a review</h1>
        <form action="writereview" method="post">
            <input type="hidden" name="productId" value="<%= request.getParameter("productId") %>">
            <label for="reviewInfo"></label>
            <textarea id="reviewInfo" name="reviewInfo" placeholder="Write your review"></textarea>

            <label for="rating">Rating:</label>
            <select id="rating" name="rating">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>

            <input type="submit" value="Submit Review">
        </form>
    </div>

</body>
</html>
