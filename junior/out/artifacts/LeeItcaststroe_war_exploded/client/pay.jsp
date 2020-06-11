<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pay</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body class="main">
    <form action="${pageContext.request.contextPath}/payServlet" method="post">
        订单号：<input type="text" name="orderid" value="${param.id}">
        支付金额：<input type="text" name="money" value="${param.money}">
        <div class="divText">选择网上银行：
            <div>
                <input type="radio" name="bank" value="ICBC-NET-B2C" checked = "checked">
                <img src="${pageContext.request.contextPath}/bank_img/icbc.bmp">
                <input type="radio" name="bank" value="CMBCHINA-NET-B2C">
                <img src="${pageContext.request.contextPath}/bank_img/cmb.bmp">
            </div>
            <input type="submit" value="确认支付">
        </div>

    </form>
</body>
</html>
