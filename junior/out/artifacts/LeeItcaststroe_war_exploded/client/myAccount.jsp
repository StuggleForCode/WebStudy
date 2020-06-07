<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myAccount</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body>
<jsp:include page="menu_search.jsp"/>
    欢迎您，${user.username}
</body>
</html>
