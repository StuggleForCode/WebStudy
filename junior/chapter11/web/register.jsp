<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style type="text/css">
        h3 {
            margin-left: 100px;
        }
        #outer {
            width: 750px;
        }
        span {
            color: #ff0000;
        }
        div {
            height: 20px;
            margin-bottom: 10px;
        }
        .ch {
            width: 80px;
            text-align: right;
            float: left;
        }
        .ip{
            width: 500px;
            float: left;
        }
        .ip>input{
            margin-right: 20px;
        }
        #bt {
            margin-left: 50px;
        }
        #bt>input {
            margin-right: 30px;
        }
    </style>
</head>
<body>

<form action="controllerServlet" method="post">
    <h3>用户注册</h3>
    <div id="outer">
        <div>
            <div class="ch">姓名：</div>
            <div class="ip">
                <input type="text" name="name" value="${formBean.name}"/>
                <span>${formBean.errors.name}${DBMes}</span>
            </div>
        </div>

        <div>
            <div class="ch">密码：</div>
            <div class="ip">
                <input type="text" name="password"/>
                <span>${formBean.errors.password}</span>
            </div>
        </div>

        <div>
            <div class="ch">确认密码：</div>
            <div class="ip">
                <input type="text" name="confirmPassword"/>
                <span>${formBean.errors.confirmPassword}</span>
            </div>
        </div>

        <div>
            <div class="ch">邮箱：</div>
            <div class="ip">
                <input type="text" name="email" value="${formBean.email}"/>
                <span>${formBean.errors.email}</span>
            </div>
        </div>

        <div id="bt">
            <input type="reset" value="重置">
            <input type="submit" value="注册">
        </div>

    </div>
</form>

</body>
</html>
