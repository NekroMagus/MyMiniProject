<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String s = (String) session.getAttribute("login");
    out.println("Hello " + s);
%>

<h1>Logout</h1>
<form action="/logout" ,method="get">
    <input type="submit" value="Sign Out">Logout</input>
</form>

<a href="index.jsp">Main</a>
</body>
</html>