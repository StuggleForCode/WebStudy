<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<script>
    function changeProductNum(count, totalCount, id) { //当商品数量变化时，触发改方法
        count =  parseInt(count);
        totalCount = parseInt(totalCount);
        //如果数量为0，判断是否要删除商品
        if(count == 0){
            var flag = window.confirm("确认是否要删除商品")
            if(!flag){
                count = 1;
            }
        }
        //如果已经达到商品最大购物量
        if(count > totalCount){
            alert("已经达到最大购物量")
            count = totalCount
        }
        location.href = "${pageContext.request.contextPath}/changeCartServlet?id="+id+"&count="+count;
    }
</script>
<body class="main">

    <div id = "divpagecontent">
        <table class="carttable">
            <tr>
                <td width="10%">序号</td>
                <td width="30%">商品名称</td>
                <td width="10%">价格</td>
                <td width="20%">数量</td>
                <td width="10%">库存</td>
                <td width="10%">小计</td>
                <td width="10%">取消</td>
            </tr>
        </table>
        <c:set value="0" var = "total"/>
        <c:forEach items="${cart}" var="entry" varStatus="vs">
            <table width="100%">
                <tr>
                    <td width="10%">${vs.count}</td>
                    <td width="30%">${entry.key.name}</td>
                    <td width="10%">${entry.key.price}</td>
                    <td width="20%">
                        <input type="button" value="-" style="width: 20px"
                               onclick="changeProductNum('${entry.value-1}', '${entry.key.pnum}','${entry.key.id}')">
                        <input type="text" value="${entry.value}" style="width: 40px;text-align: center">
                        <input type="button" value="+" style="width: 20px"
                               onclick="changeProductNum('${entry.value+1}', '${entry.key.pnum}','${entry.key.id}')">
                    </td>
                    <td width="10%">${entry.key.pnum}</td>
                    <td width="10%">${entry.key.price * entry.value}</td>
                    <td width="10%">X</td>
                </tr>
            </table>
            <c:set value="${total + entry.key.price * entry.value}" var = "total"/>
        </c:forEach>
        <table class="carttable">
            <tr>
                <td style="text-align: right">合计：${total}元</td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/showProductByPageServlet"><img src="${pageContext.request.contextPath}/images/gwc_jx.gif"></a>
        <a href="${pageContext.request.contextPath}/client/order.jsp"><img src="${pageContext.request.contextPath}/images/gwc_buy.gif"></a>
    </div>

</body>
</html>
