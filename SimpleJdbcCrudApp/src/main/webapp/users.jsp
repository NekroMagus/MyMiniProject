<%@ page import="service.UserService" %>
<%@ page import="service.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div><h1>All Users</h1></div>
<%
    UserService userService = new UserServiceImpl();
    out.println(userService.getAllUser());
%>
<h2>Add User</h2>
<form action="/users" method="post">
    <div><label> User Name : <input type="text" name="name"/> </label></div>
    <div><input type="submit" value="add user"/></div>
</form>

<h2>Delete User</h2>
<form action="/deluser" method="post">
    <div><label>Delete user by id : <input type="number" name="id"/></label></div>
    <div><input type="submit" value="del user"/></div>
</form>

<h2>Update User</h2>
<form action="/upduser" method="post">
    <div><label>Enter id user: <input type="number" name="id"/></label></div>
    <div><label>Enter new name : <input type="text" name="name"/></label></div>
    <div><input type="submit" value="upd user"/></div>
</form>
</body>
</html>