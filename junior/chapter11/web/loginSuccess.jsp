<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginSuceess</title>
    <style type="text/css">
        #main {
            width: 500px;
            height: auto;
        }

        #main div{
            width: 200px;
            height: auto;
        }

        ul {
            padding-top: 1px;
            padding-left: 1px;
            list-style: none;
        }
    </style>
</head>
<body>
    <%
        if(session.getAttribute("userBean") == null){
    %>
    <jsp:forward page="register.jsp"></jsp:forward>
    <%
        return;
        }
    %>
    <div id="main">
        <div id="welcome">恭喜您，登陆成功</div>
        <hr>
        <div>您的信息</div>
        <div>
            <ul>
                <li>您的姓名：${userBean.name}</li>
                <li>您的邮箱：${userBean.email}</li>
            </ul>
        </div>
    </div>
</body>
</html>
