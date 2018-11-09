<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/style/style.css">
    <title>Login page</title>
</head>
<body>
<div align="center">
    <div style="width: 300px; height: 500px;">
        <form:form method="POST" action="/login" modelAttribute="user">
            <div class="imgcontainer">
                <img src="../resources/pictures/incognito.jpg" alt="Avatar" class="avatar">
            </div>
            <h3 align="center" style="color:maroon;">Hey, dude! Log in, please</h3>

            <div class="container" align="left">
                <label>Username</label>
                <input type="text" name="username" required="required"/>

                <label>Password</label>
                <input type="password" name="password" required="required"/>

                <p style="color:red">${error}</p>
                <button type="submit">Login</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
