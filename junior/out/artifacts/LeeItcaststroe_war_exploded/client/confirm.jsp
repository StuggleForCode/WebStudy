<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pay</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body class="main">
<%--    确认支付--%>
    <form action="${pageContext.request.contextPath}/changeOrderStateServlet" method="post">
        订单号：${orderid}，付款金额：${money}<br>
        <input type="hidden" name="orderid" value="${orderid}">
        <input type="submit" value="确认支付">
    </form>
</body>
</html>
