<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operation View</title>
</head>
<body>
<form action="/history/operation" method="post">
    <input type="text" name="value" placeholder="operation">
    <button>View</button>
</form>
${operations}
${message}
<br>
<br>
<a href="/history"><button>Return</button></a>
</body>
</html>
