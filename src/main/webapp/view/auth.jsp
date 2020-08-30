<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autorization</title>
</head>
<body>
<form action="/user/auth" method="post">
    <input type="text" name="login" placeholder="login" minlength="3" required>
    <input type="text" name="password" placeholder="password" minlength="3" required>
    <button>Ok</button>
</form>
${message}
</body>
</html>
