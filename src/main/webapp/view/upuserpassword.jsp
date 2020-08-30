<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Password</title>
</head>
<body>
<form action="/user/uppassword" method="post">
    <input type="text" name="password" placeholder="enter new password">
    <button>Submit</button>
</form>
<p style="color: red">${message}</p>
<br>
<br>
<a href="/user/cabinet"><button>Back</button></a>
</body>
</html>
