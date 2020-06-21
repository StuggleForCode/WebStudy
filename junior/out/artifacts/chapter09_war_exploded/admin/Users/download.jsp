<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><!-- 后台管理页面，销售榜单 -->
<head>
    <title>download</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/downLoadServlet">
            <tr>
                <td colspan="4"><input type="submit" value="下载所有用户信息" align="right"></td>
            </tr>

        </table>
    </form>

</body>
</html>
