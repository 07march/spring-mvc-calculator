<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:form action="/calc" modelAttribute="operation" method="post">
    <br>
    <c:input path="num1" placeholder="num1"/>
    <br>
    <c:errors path="num1"/>
    <br>
    <c:input path="num2" placeholder="num2"/>
    <br>
    <c:errors path="num2"/>
    <br>
    <c:input path="operation" placeholder="operation"/>
    <br>
    <c:errors path="operation"/>
    <br>
    <c:button>Ok</c:button>
</c:form>
${result}
<br>
<br>
<a href="/"><button>Return on user page</button></a>
</body>
</html>
