<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User History</title>
</head>
<body>
<ul style="list-style: decimal">
    <c:forEach items="${operations}" var="operation">
        <li>Operation: ${operation.operation}; number 1: ${operation.num1}; number 2: ${operation.num2}; result: ${operation.result}.</li>
    </c:forEach>
</ul>
${message}
<br>
<br>
<a href="/history"><button>Return</button></a>
</body>
</html>
