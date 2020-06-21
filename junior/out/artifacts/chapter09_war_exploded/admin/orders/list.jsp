<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%--    后台管理页面，显示查询条件，订单列表--%>
    <title>list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/findOrderByManyConditionServlet">
        <table width="100%" align="center" bgcolor="#f5fafe" border="0">
            <tr><td colspan="4" class="ta_01" align="center" bgcolor="#afd1f3"><strong>查询条件</strong></td></tr>
            <tr>
                <td align="right" bgcolor="#f5fafe" class="ta_01" width="25%">订单编号</td>
                <td bgcolor="#ffffff" class="ta_01" width="15%"><input type="text" name="id"></td>
                <td align="right" bgcolor="#f5fafe" class="ta_01" width="25%">收件人</td>
                <td bgcolor="#ffffff" class="ta_01" ><input type="text" name="receiverName"></td>
            </tr>
            <tr>
                <td colspan="4" bgcolor="#ffffff" class="ta_01"  align="right"><input type="submit" value="查询"></td>
            </tr>
        </table>
    </form>

    <table width="100%">
        <tr><td colspan="9" class="ta_01" align="center" bgcolor="#afd1f3"><strong>订单列表</strong></td></tr>
        <tr style="font-weight:bold;font-size:12px;background-color: #afd1f3"> <!-- 表头行 -->
            <td align="center" width="20%">订单编号</td>
            <td align="center" width="10%">收件人</td>
            <td align="center" width="15%">地址</td>
            <td align="center" width="10%">联系电话</td>
            <td align="center" width="11%">总价</td>
            <td align="center" width="8%">所属用户</td>
            <td align="center" width="10%">订单状态</td>
            <td align="center" width="7%">查看</td>
            <td align="center" width="7%">删除</td>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr style="font-size:11px;background-color: #F5fafe">
                <td align="center" width="20%">${order.id}</td>
                <td align="center" width="10%">${order.receiverName}</td>
                <td align="center" width="15%">${order.receiverAddress}</td>
                <td align="center" width="10%">${order.receiverPhone}</td>
                <td align="center" width="11%">${order.money}</td>
                <td align="center" width="8%">${order.user.username}</td>
                <td align="center" width="10%">${order.payState==0?"未支付":"已支付"}</td>
                <td align="center" width="7%">
                    <a href="${pageContext.request.contextPath}/findOrderByIdServlet?id=${order.id}&type=admin">
                        <img src="${pageContext.request.contextPath}/admin/images/button_view.gif">
                    </a>
                </td>
                <td align="center" width="7%">
                    <a href="${pageContext.request.contextPath}/delOrderByIdServlet?id=${order.id}&type=admin">
                        <img src="${pageContext.request.contextPath}/admin/images/i_del.gif">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
