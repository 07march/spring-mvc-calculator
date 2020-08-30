<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<c:forEach items="${all}" var="his">
    <p>${his}</p>
    <br>
</c:forEach>
</body>
</html>
