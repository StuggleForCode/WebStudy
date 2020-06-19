<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><!-- 后台管理页面，销售榜单 -->
<head>
    <title>download</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/downLoadServlet">
        <table width="100%" align="center" bgcolor="#f5fafe">
            <tr><td colspan="4" align="center" bgcolor="#afd1f3"><strong>查询条件</strong></td></tr>
            <tr>
                <td>输入年份：</td>
                <td><input type="text" name="year" width="15%"></td>
                <td align="right">输入月份</td>
                <td>
                    <select name="month">
                        <option value="0" selected>--选择月份--</option>
                        <option value="1">一月</option>
                        <option value="2">二月</option>
                        <option value="3">三月</option>
                        <option value="4">四月</option>
                        <option value="5">五月</option>
                        <option value="6">六月</option>
                        <option value="7">七月</option>
                        <option value="8">八月</option>
                        <option value="9">九月</option>
                        <option value="10">十月</option>
                        <option value="11">十一月</option>
                        <option value="12">十二月</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="下载" align="right"></td>
            </tr>

        </table>
    </form>

</body>
</html>
