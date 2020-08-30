<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<form action="/history/result" method="post">
    <input type="number" name="value" placeholder="result" min="40" minlength="10" maxlength="60" required>
    <button>Ok</button>
</form>
${result}
${message}
<br>
<br>
<a href="/history"><button>Return</button></a>
</body>
</html>
