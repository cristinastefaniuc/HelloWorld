<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/style/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="../resources/js/hello.js"></script>
    <title>Users</title>
</head>
<body>
<%--<h3>Selected user = ${userById.username}</h3>--%>

<h3>All users usernames:</h3>
<c:forEach items="${userList}" var="user">
    <p>${user.username}</p>
</c:forEach>

<h3>Json example:</h3>
<input type="button" style="width: 100px" value="Show users" onclick="getAllUsersAsJson()"/>
<div id="users"></div>
</body>
</html>
