<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/autoplay.js"></script>

</head>
<body class="main">
<jsp:include page="menu_search.jsp"/>
    <!--首页轮播图 开始-->
<%--    <div id = "box_autoplay">--%>
<%--        <div class = "list">--%>
<%--            <ul>--%>
<%--                <li><img src = "${pageContext.request.contextPath}/client/ad/index_ad1.jpg" width = "900" height = "335"/></li>--%>
<%--                <li><img src = "${pageContext.request.contextPath}/client/ad/index_ad3.jpg" width = "900" height = "335"/></li>--%>
<%--                <li><img src = "${pageContext.request.contextPath}/client/ad/index_ad3.jpg" width = "900" height = "335"/></li>--%>
<%--                <li><img src = "${pageContext.request.contextPath}/client/ad/index_ad4.jpg" width = "900" height = "335"/></li>--%>
<%--                <li><img src = "${pageContext.request.contextPath}/client/ad/index_ad5.jpg" width = "900" height = "335"/></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
    <!--首页轮播图  结束-->


<%--    公告板、本周热卖start--%>
    <div id = "divcontent">
        <table>
            <tr>
                <td width="497"><!--公告板 -->
                    <img src="${pageContext.request.contextPath}/images/billboard.gif" width="497" height="38">
                    ${n.details}
                </td>
                <td><!--本周热卖 -->
                    <table>
                        <tr>
                            <img src="${pageContext.request.contextPath}/images/hottitle.gif" width="126" height="29">
                            <c:forEach items="${pList}" var="pArray">
                                <td>
                                   <a href="${pageContext.request.contextPath}/findProductByIdServlet?id=${pArray[0]}">
                                       <img src="${pageContext.request.contextPath}${pArray[2]}" width="102" height="130"> <br>
                                           ${pArray[1]}
                                   </a>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
<%--    公告板、本周热卖end--%>
</body>
</html>
