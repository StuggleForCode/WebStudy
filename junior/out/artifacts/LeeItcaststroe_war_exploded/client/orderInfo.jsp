<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orderInfo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body class="main">
<jsp:include page="menu_search.jsp"/>
<div id="divpagecontent">
    订单编号：${order.id}
    <table lass="carttable">
        <tr>
            <td width="10%">序号</td>
            <td width="40%">商品名称</td>
            <td width="10%">价格</td>
            <td width="10%">数量</td>
            <td width="10%">小计</td>
        </tr>
    </table>
    <c:forEach items="${order.orderItemList}" var="item" varStatus="vs">
        <table width="100%">
            <tr>
                <td width="10%">${vs.count}</td>
                <td width="40%">${item.product.name}</td>
                <td width="10%">${item.product.price}</td>
                <td width="10%">${item.buyNum}</td>
                <td width="10%">${item.buyNum * item.product.price}</td>
            </tr>
        </table>
    </c:forEach>
    <table class="carttable">
        <tr>
            <td style="text-align: right">合计：${order.money}</td>
        </tr>
    </table>
    收获地址：${order.receiverAddress}<br/>
    收货人：：${order.receiverName}<br/>
    联系方式：：${order.receiverPhone}<br/>
    <c:if test="${order.payState != 1}">
        <a href="${pageContext.request.contextPath}/client/pay.jsp?id=${order.id}&money=${order.money}">
            <img src="${pageContext.request.contextPath}/images/gif53_030.gif"></a>
    </c:if>
</div>
</body>
</html>
