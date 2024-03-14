<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/form.css">
  <title>Login</title>
</head>
<body>
<form id="form-container" action="${pageContext.request.contextPath}/login" method="post">
  <input type="text" id="email" name="email" placeholder="Email" required>
  <label for="password"></label>
  <input type="password" id="password" name="password" placeholder="Password" required>
  <button type="submit">Login</button>
</form>
</body>
</html>
