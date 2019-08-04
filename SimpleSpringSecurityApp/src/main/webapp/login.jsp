<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/login" method="post">
        <h2>Sign in</h2>
        <input type="text" name="username" placeholder="login" required autofocus>
        <input type="password" name="password" placeholder="password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
    <div><a href = "admin">Admin page</a></div>
    <div><a href ="users">Users page</a></div>
    <div><a href ="/">Home page</a></div>
</div>
</body>
</html>
