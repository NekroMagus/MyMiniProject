<%@ page import="entities.Role" %>
<%@ page import="service.UserService" %>
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
        out.println(UserService.getInstance().getAllUsers());
%>
<h2>Add User</h2>
<form action="/adduser" method="post">
    <div><label> User Login : <input type="text" name="login"/> </label></div>
    <div><label> User Password : <input type="password" name="password"/> </label></div>
    <div><label> User Role : <input name="role" , type="radio" , value="user" checked/>user</label>
        <label><input name="role" , type="radio" , value="admin"/>admin</label></div>
    <div><input type="submit" value="add User"/></div>
</form>

<h2>Delete User</h2>
<form action="/deluser" method="post">
    <div><label>Delete user by id : <input type="number" name="id"/></label></div>
    <div><input type="submit" value="delete User"/></div>
</form>

<h2>Update User</h2>
<form action="/upduser" method="post">
    <div><label>Enter id User: <input type="number" name="id"/></label></div>
    <div><label>Enter new Login : <input type="text" name="login"/></label></div>
    <div><label>Enter new Password : <input type="password" , name="password"/></label></div>
    <div><input type="submit" value="update User"/></div>
</form>

<a href="index.jsp">Main</a>

<%
    String s = (String) session.getAttribute("login");
    out.println("Hello " + s);
%>
</body>
</html>