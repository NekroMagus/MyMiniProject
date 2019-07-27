
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Users:</h1>
<div>User: ${users}</div>

<h2>Add User</h2>
<form action="/admin/addUser" method="post">
    <div><label> User Login : <input type="text" name="login"/> </label></div>
    <div><label> User Password : <input type="password" name="password"/> </label></div>
    <div><label> User Role : <input name="role" , type="radio" , value="user" checked/>user</label>
        <label><input name="role" , type="radio" , value="admin"/>admin</label></div>
    <div><input type="submit" value="add User"/></div>
</form>

<h2>Delete User</h2>
<form method="post">
    <div><label>Delete user by id : <input type="number" name="id"/></label></div>
    <div><input type="submit" value="delete User"/></div>
</form>

<h2>Update User</h2>
<form action="/admin/updateUser" method="post">
    <div><label>Enter id User: <input type="number" name="id"/></label></div>
    <div><label>Enter new Login : <input type="text" name="login"/></label></div>
    <div><label>Enter new Password : <input type="password" name="password"/></label></div>
    <div><input type="submit" value="update User"/></div>
</form>
</body>
</html>
