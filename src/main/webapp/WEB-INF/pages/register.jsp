<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mbezaliuc
  Date: 11/13/2018
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resources/style/style.css">
</head>
<body>
<div align="center">
    <div style="width: 300px; height: 500px;">
        <form:form method="POST" action="/register" modelAttribute="user">
            <div class="imgcontainer">
                <img src="../resources/pictures/incognito.jpg" alt="Avatar" class="avatar">
            </div>
            <h3 align="center" style="color:maroon;">Hey, dude! Log in, please</h3>

            <div class="container" align="left">
                <label>Username</label>
                <input type="text" name="username" required="required"/>

                <label>Password</label>
                <input type="password" name="password" required="required"/>

                <label>Age</label>
                <input type="text" name="age" required="required"/>

                <input type="radio" name="gender" value="FEMALE"> FEMALE
                <input type="radio" name="gender" value="MALE"> MALE
                <br>

                <p style="color:red">${error}</p>
                <button type="submit">Login</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
