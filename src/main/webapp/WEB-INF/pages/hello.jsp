<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/style/style.css">
    <title>Hello page</title>
</head>
<h1>Hello, ${username}</h1>

<form:form action="/show-users" method="POST" style="border: none;">
    <label>
        <input type="text" name="status" style="width: 200px; ">
    </label>
    <br>
    <input type="submit" style="width: 200px; background-color: maroon; font-size: medium" value="Take status and show users"/>
</form:form>

<c:forEach items="${userList}" var="user">
    <p>${user.username} - ${user.status}</p>
</c:forEach>

<a href="/show-users">Show all users page</a>
</body>
</html>