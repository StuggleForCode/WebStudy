<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addProduct</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/editUserServlet?uId=${user.uId}" >
        <table width="100%" align="center" bgcolor="#eeeeee" style="border:1px solid #8ba7e3">
            <tr><td align="center" bgcolor="afd1f3" colspan="4"><strong>修改用户</strong></td></tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">用户名:</td>
                <td><input type="text" name="uName" class="bg" value="${user.uName}"></td>
                <td align="center" bgcolor="#f5fafe">密码:</td>
                <td><input type="text" name="uPassword" class="bg" value="${user.uPassword}"></td>
            </tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">生日:</td>
                <td><input type="text" name="uBirthday" class="bg" value="${user.uBirthday}"></td>
                <td align="center" bgcolor="#f5fafe">家庭住址:</td>
                <td><input type="text" name="uAddress" class="bg" value="${user.uAddress}"></td>
            </tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">银行卡号：</td>
                <td><input type="text" name="uBankId" class="bg" value="${user.uBankId}"></td>
            </tr>
            <tr>
                <td width="100%" align="center" colspan="4"><input type="submit" value="确定" class="bg"></td>
            </tr>
        </table>
    </form>
</body>
</html>
