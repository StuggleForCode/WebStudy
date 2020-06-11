<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myAccount</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body class="main">
<jsp:include page="menu_search.jsp"/>
    欢迎您，${user.username}
    <div id = "divpagecontent">
        <table width="100%">
            <tr>
                <td class="listtitle">我的账户</td>
            </tr>
            <tr>
                <td class="listtd">
                    <a href="${pageContext.request.contextPath}/findOrderByUserServlet">订单查询</a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
