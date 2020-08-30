<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
Welcome ${sessionScope.currentUser.name}!
<br>
<br>
<c:if test="${sessionScope.currentUser == null}">
    <p>Sign up or Log in!</p>
    <a href="/user/reg">
        <button>Registration</button>
    </a>
    <br>
    <br>
    <a href="/user/auth">
        <button>Autorization</button>
    </a>
</c:if>
<c:if test="${sessionScope.currentUser != null}">
    1. <a href="/calc">
        <button>Calculator page</button>
    </a>
    <br>
    <br>
    2. <a href="/history">
        <button>History page</button>
    </a>
    <br>
    <br>
    3. <a href="/user/cabinet">
        <button>User cabinet</button>
    </a>
    <br>
    <br>
    4. <a href="/user/logout">
    <button>Exit</button>
</a>
</c:if>
</body>
</html>
