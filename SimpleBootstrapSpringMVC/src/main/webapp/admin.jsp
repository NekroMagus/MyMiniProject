<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">


    <link rel="stylesheet" href="/static/listpage.css"/>
    <title>Страничка админа</title>
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
                <li class="active"><a href="/admin">Admin <span class="sr-only">(current)</span></a></li>
                <li><a href="/users">User</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Admin panel</h1>

            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                          data-toggle="tab">Users table</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">New
                    User</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">

                    <h4>All users</h4>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Role</th>
                            <th>Login</th>
                            <th>Password</th>
                            <th>Email</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${users}" var="userlist">
                        <tr>
                            <td>${userlist.id}</td>
                            <td>${userlist.role}</td>
                            <td>${userlist.login}</td>
                            <td>${userlist.password}</td>
                            <td>some</td>
                            <td>                    <!-- Button trigger modal -->
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                        data-target="#myModal">
                                    Edit
                                </button>
                            </td>
                        </tr>

                        </tbody>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close"><span
                                                aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">Edit user ${userlist.login}</h4>
                                    </div>
                                    <form action="/admin/updateUser" method="post">
                                        <div class="modal-body">


                                            <div class="col-md col-md-offset-4"><label>ID<input class="form-control"
                                                                                                type="text" name="id"
                                                                                                value="${userlist.id}"
                                                                                                disabled
                                            ></label></div>
                                            <div class="col-md col-md-offset-4"><label>Email<input class="form-control"
                                                                                                   type="text"/></label>
                                            </div>
                                            <div class="col-md col-md-offset-4"><label>Login<input class="form-control"
                                                                                                   type="text"
                                                                                                   name="login"/></label>
                                            </div>
                                            <div class="col-md col-md-offset-4"><label>Password<input
                                                    class="form-control"
                                                    type="password"
                                                    name="password"/></label>
                                            </div>
                                            <div class="col-md col-md-offset-4"><label>Role<input class="form-control"
                                                                                                  type="text"/></label>
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                            </button>
                                            <button type="submit" class="btn btn-primary">Edit user</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </table>
                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                    <h4>Add new user</h4>
                    <div class="tab-panels">
                    <form action="/admin/addUser" method="post">
                        <div class="row">
                            <div class="col-md-4 col-md-offset-4"><label>Email<input class="form-control"
                                                                                   type="text"/></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-md-offset-4"><label>Login<input class="form-control"
                                                                                   type="text"
                                                                                   name="login"/></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-md-offset-4"><label>Password<input
                                    class="form-control"
                                    type="password"
                                    name="password"/></label>
                            </div>
                        </div>
                        <div class="row">
                            <select class = "form-control" id="role" name = "role" required>
                                <option value  = "ADMIN" selected >ADMIN</option>
                                <option value = "USER">USER</option>
                            </select>
                        </div>
                         <div class="row">
                            <div class="col-md col-md-offset-5">
                                <button type="submit" class="btn btn-success">Add new user</button>
                            </div>
                    </div>

                    </form>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<script stc="/static/modal.js"></script>
<script stc="/static/tab.js"></script>
</body>
</html>
