<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orderList</title>
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

        <table width="100%" class="infocontent">
            <tr>
                <td>
                    我的订单共有${orders.size()}笔订单
                    <table width="100%" class="tableopen">
                        <tr>
                            <td bgcolor="#A3E6DF">订单号</td>
                            <td bgcolor="#A3E7DF">收件人</td>
                            <td bgcolor="#A3CCE6">订单时间</td>
                            <td bgcolor="#A3B6E6">状态</td>
                            <td bgcolor="#A3E2E6">操作</td>
                        </tr>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.receiverName}</td>
                                <td>${order.orderTime}</td>
                                <td>${order.payState==0?"未支付":"已支付"}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/findOrderByIdServlet?id=${order.id}">查看</a>
                                    <c:if test="${order.payState == 0}">
                                        <a href="${pageContext.request.contextPath}/delOrderByIdServlet?id=${order.id}">删除</a>
                                    </c:if>
                                    <c:if test="${order.payState != 0}">
                                        <a href="${pageContext.request.contextPath}/delOrderByIdServlet?id=${order.id}&type=client">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>

        </table>


    </div>
</body>
</html>
