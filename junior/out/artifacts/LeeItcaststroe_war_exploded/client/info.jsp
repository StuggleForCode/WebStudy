<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>info</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body class="main">商品详情页

    <table>
        <tr>
            <td>
                <div class="divbookcover">
                   <img src="${pageContext.request.contextPath}${p.imgurl}"/>
                </div>
                <div style="text-align: center" >
                    <a href="${pageContext.request.contextPath}/addCartServlet?id=${p.id}">
                        <img src="${pageContext.request.contextPath}/images/buybutton.gif">
                    </a>
                </div>
            </td>
            <td>
                ${p.name}
                <hr>售价：￥${p.price}
                <hr>类别：￥${p.category}
                <hr>
                <p>内容简介</p>${p.description}
            </td>
        </tr>
    </table>



</body>
</html>
