<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<%--    后台管理页面，显示查询条件，商品列表--%>
    <form action="${pageContext.request.contextPath}/findProductByManyConditionServlet" method="post" name="form1">
        <table bgcolor="#f5fafe" width="100%"><!-- 显示查询条件 -->
            <tr><td class="ta_01" align="center" bgcolor="#afd1f3" colspan="4"><strong>查询条件</strong></td></tr>
            <tr>
                <td align="right" width="20%">商品编号</td>
                <td><input type="text" name="id"></td>
                <td align="right">类别</td>
                <td>
                    <select name="category">
                        <option value="文学" selected="selected">文学</option>
                        <option value="生活">生活</option>
                        <option value="计算机">计算机</option>
                        <option value="外语">外语</option>
                        <option value="经管">经管</option>
                        <option value="励志">励志</option>
                        <option value="社科">社科</option>
                        <option value="学术">学术</option>
                        <option value="少儿">少儿</option>
                        <option value="艺术">艺术</option>
                        <option value="原版">原版</option>
                        <option value="科技">科技</option>
                        <option value="考试">考试</option>
                        <option value="生活百科">生活百科</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%">商品名称</td>
                <td><input type="text" name="name"></td>
                <td  align="right" width="20%">价格区间</td>
                <td colspan="4">
                    <input type="text" name="minprice">-<input type="text" name="maxprice">
                </td>
            </tr>
            <tr>
                <td align="right" colspan="7">
                    <input type="submit" value="查询">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>

    <form method="post" action="${pageContext.request.contextPath}/admin/products/add.jsp">
        <table style="background-color: #F5fafe; border-collapse: collapse" width="100%"><!-- 显示添加按钮 -->
            <tr><td class="ta_01" align="center" bgcolor="#afd1f3"><strong>商品列表</strong></td></tr>
            <tr>
                <td align="right">
                    <input type="submit" value="添加">
                </td>
            </tr>
        </table>
    </form>

    <table border=1 style="background-color: #F5fafe; border-collapse: collapse" width="100%"><!-- 显示商品列表 -->
        <tr style="font-weight: bold; font-size: 12px; height:25px; background-color: #afd1f3">
            <td align="center" width="24%">商品编号</td>
            <td align="center" width="18%">商品名称</td>
            <td align="center" width="9%">商品价格</td>
            <td align="center" width="9%">商品数量</td>
            <td align="center" width="8%">商品类别</td>
            <td align="center" width="8%">编辑</td>
            <td align="center" width="8%">删除</td>
        </tr>
<%--        循环输出所有商品--%>
        <c:forEach items="${ps}" var="p">
            <tr style="font-size: 11px">
                <td align="center" width="24%">${p.id}</td>
                <td align="center" width="18%">${p.name}</td>
                <td align="center" width="9%">${p.price}</td>
                <td align="center" width="9%">${p.pnum}</td>
                <td align="center" width="8%">${p.category}</td>
                <td align="center" width="8%">
                    <a href="${pageContext.request.contextPath}/findProductByIdServlet?id=${p.id}&type=admin">
                    <img src="../images/i_edit.gif">
                    </a>
                </td>
                <td align="center" width="8%">
                    <a href="${pageContext.request.contextPath}/deleteProductServlet?id=${p.id}&type=admin">
                        <img src="../images/i_del.gif">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
