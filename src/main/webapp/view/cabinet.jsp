<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>
<body>
Info about you:
<br>
- name: ${sessionScope.currentUser.name};
<br>
- age: ${sessionScope.currentUser.age};
<br>
- login: ${sessionScope.currentUser.login};
<br>
- password: ${sessionScope.currentUser.password}.
<br>
<br>
1. <a href="/user/upname"><button>Update name</button></a>
<br>
<br>
2. <a href="/user/uplogin"><button>Update login</button></a>
<br>
<br>
3. <a href="/user/uppassword"><button>Update password</button></a>
<br>
<br>
4. <a href="/"><button>Return on user page</button></a>
</body>
</html>
