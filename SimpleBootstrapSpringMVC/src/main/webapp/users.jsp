<%@ page import="com.simple.springmvc.model.User" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.simple.springmvc.model.Role" %>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">


    <link rel="stylesheet" href="/static/listpage.css"/>  <title>Страничка пользователей</title>
</head>
<body>

<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <a class="navbar-brand" href="#"> Project name</a>
        <a class="navbar-right navbar-brand" href="/logout">Logout</a>
    </nav>
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/admin">Admin</a></li>
                <li class="active"><a href="/users">User <span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1  class="page-header">User page</h1>
            <div>Hello <% Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Role role = null;
            for(GrantedAuthority grantedAuthority:auth.getAuthorities()){
                role = Role.valueOf(grantedAuthority.getAuthority());
            }
            out.print(role + " ");
            out.print(auth.getName() + "!");
            %></div>
        </div>
    </div>
</div>
<</body>
</html>
