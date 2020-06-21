<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<%--    后台管理页面，显示查询条件，用户列表--%>
    <form action="${pageContext.request.contextPath}/findUserByManyConditionServlet" method="post" name="form1">
        <table bgcolor="#f5fafe" width="100%"><!-- 显示查询条件 -->
            <tr><td class="ta_01" align="center" bgcolor="#afd1f3" colspan="4"><strong>查询条件</strong></td></tr>
            <tr>
                <td align="right" width="20%">用户编号</td>
                <td><input type="text" name="uId"></td>
                <td align="right">用户姓名</td>
                <td><input type="text" name="uName"></td>
            </tr>
            <tr>
                <td align="right" width="20%">银行卡号</td>
                <td><input type="text" name="BankId"></td>
            </tr>
            <tr>
                <td align="right" colspan="7">
                    <input type="submit" value="查询">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>

    <form method="post" action="${pageContext.request.contextPath}/admin/Users/add.jsp">
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
            <td align="center" width="8%">用户编号</td>
            <td align="center" width="9%">姓名</td>
            <td align="center" width="9%">密码</td>
            <td align="center" width="9%">生日</td>
            <td align="center" width="18%">地址</td>
            <td align="center" width="9%">银行卡号</td>
            <td align="center" width="8%">编辑</td>
            <td align="center" width="8%">删除</td>
        </tr>
<%--        循环输出所有商品--%>
        <c:forEach items="${users}" var="u">
            <tr style="font-size: 11px">
                <td align="center" width="8%">${u.uId}</td>
                <td align="center" width="9%">${u.uName}</td>
                <td align="center" width="9">${u.uPassword}</td>
                <td align="center" width="9%">${u.uBirthday}</td>
                <td align="center" width="18%">${u.uAddress}</td>
                <td align="center" width="8%">${u.uBankId}</td>
                <td align="center" width="8%">
                    <a href="${pageContext.request.contextPath}/findUserByIdServlet?id=${u.uId}">
                    <img src="../images/i_edit.gif">
                    </a>
                </td>
                <td align="center" width="8%">
                    <a href="${pageContext.request.contextPath}/deleteUserServlet?id=${u.uId}">
                        <img src="../images/i_del.gif">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
