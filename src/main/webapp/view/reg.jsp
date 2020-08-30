<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:form action="/user/reg" method="post" modelAttribute="user">
    <c:input path="name" placeholder="name"/>
    <br>
    <c:errors path="name"/>
    <br>
    <c:input path="login" placeholder="login"/>
    <br>
    <c:errors path="login"/>
    <br>
    <c:input path="password" placeholder="password"/>
    <br>
    <c:errors path="password"/>
    <br>
    <c:input path="age" placeholder="age"/>
    <br>
    <c:errors path="age"/>
    <br>
    <c:button>Reg</c:button>
</c:form>
</body>
</html>
