<%--
  Created by IntelliJ IDEA.
  User: 27289
  Date: 2020/2/18
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")%>，欢迎你！</h1>
</body>
</html>
