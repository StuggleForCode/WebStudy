<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
    <a href="${pageContext.request.contextPath}/listProductServlet" target="mainFrame" class="left_list">商品管理</a><br>
    <a href="${pageContext.request.contextPath}/admin/products/download.jsp" target="mainFrame" class="left_list">销售榜单</a><br>
    <a href="${pageContext.request.contextPath}/findOrdersServlet" target="mainFrame" class="left_list">订单管理</a><br>
    <a href="${pageContext.request.contextPath}/manager/ListNoticeServlet" target="mainFrame" class="left_list">公告管理</a><br>
</body>
</html>
