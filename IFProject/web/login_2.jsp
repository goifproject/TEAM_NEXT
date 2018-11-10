<%--
  Created by IntelliJ IDEA.
  User: maxkss
  Date: 2018. 10. 27.
  Time: PM 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="post" action="/api/login">
        <input type="text" name="userid" placeholder="아이디">
        <input type="password" name="userpw" placeholder="패스워드">
        <input type="submit" value="로그인">
    </form>
</body>
</html>
