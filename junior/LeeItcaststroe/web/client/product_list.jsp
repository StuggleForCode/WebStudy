<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product_list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<table>
    <tr>
        <h2>商品目录</h2>
        <hr/>
        ${bean.category}共有${bean.totalCount}种商品
        <table class="booklist">
            <tr>
                <c:forEach items="${bean.ps}" var="p">
                    <td>
                        <div class="divbookpic">
                            <a href="${pageContext.request.contextPath}/findProductByIdServlet?id=${p.id}"><img src="${pageContext.request.contextPath}${p.imgurl}"></a>
                        </div>
                        书名：${p.name}<br>
                        售价：￥${p.price}
                    </td>

                </c:forEach>
            </tr>
        </table>
        <div class="pagination"><!--有上一页， 无上一页， 有下一页， 无下一页 -->
            <!--有上一页-->
            <c:if test="${bean.currentPage != 1}">
                <li class="disablepage_p">
                    <a class="disablepage_a" href="${pageContext.request.contextPath}/showProductByPageServlet?currentPage=${bean.currentPage - 1}&category=${bean.category}"></a>
                </li>
            </c:if>
            <!--无上一页，-->
            <c:if test="${bean.currentPage == 1}">
                <li class="disablepage_p2">
                </li>
            </c:if>
            <!-- 显示页面页码， 当前页没有链接，其他页有链接 -->
            <c:forEach begin = "1" end="${bean.totalPage}" var="pageNum" >
                <c:if test="${pageNum == bean.currentPage}"> <!-- 是当前页 -->
                    <li class="currentpage">${pageNum}</li>
                </c:if>
                <c:if test="${pageNum != bean.currentPage}"> <!-- 不是当前页 -->
                    <li><a href="${pageContext.request.contextPath}/showProductByPageServlet?currentPage=${pageNum}&category=${bean.category}">${pageNum}</a></li>
                </c:if>
            </c:forEach>
            <!--有下一页-->
            <c:if test="${bean.currentPage != bean.totalPage && bean.totalPage != 0}">
                <li class="disablepage_n">
                    <a class="disablepage_a" href="${pageContext.request.contextPath}/showProductByPageServlet?currentPage=${bean.currentPage + 1}&category=${bean.category}"></a>
                </li>
            </c:if>
            <!--无下一页，-->
            <c:if test="${bean.currentPage == bean.totalPage || bean.totalPage == 0}">
                <li class="disablepage_n2">
                </li>
            </c:if>

        </div>

    </tr>

</table>


</body>
</html>
