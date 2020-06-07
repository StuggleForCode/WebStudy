<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/registerServlet">
        邮箱：<input type="text" name="email"><br>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        重复密码：<input type="password" name="repassword"><br>
        性别：<input type="radio" name="gender" value="男" checked="checked">男
        <input type="radio" name="gender" value="女">女
        联系电话：<input type="text" name="telephone"><br>
        个人介绍：<textarea name="introduce"></textarea><br>
        注册验证：<br>
        输入验证码：<input type="text"><br>
        <img src="${pageContext.request.contextPath}/checkImageServlet" width="180px" height="30px">
        <input type="submit" value="提交">
    </form>
</body>
</html>
