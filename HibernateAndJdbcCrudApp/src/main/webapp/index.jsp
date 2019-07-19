<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" , method="post">
    <div>Enter you login: <input type="text" , name="login" , required/></div>
    <div>Enter you password: <input type="password" , name="password" , required/></div>
    <input type="submit" value="Sign In"/>
</form>

<a href="user.jsp">users</a>
<a href="admin.jsp">admin</a>
</body>
</html>