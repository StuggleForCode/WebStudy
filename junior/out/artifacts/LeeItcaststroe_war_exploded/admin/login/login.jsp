<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
管理员登陆
    <form method="post" action="${pageContext.request.contextPath}/admin/login/home.jsp">
        用户名：<input type="text" name="loginName"><br>
        密码：<input type="password" name="loginPwd"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
