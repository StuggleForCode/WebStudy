<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 27289
  Date: 2020/2/18
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcast</title>
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    boolean ok = false;
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
    String str_date = sdf.format(date);
//    System.out.println("编码器前："+ str_date);
    str_date = URLEncoder.encode(str_date,"utf-8");
//    System.out.println("编码后：" + str_date);
    if(cookies != null){
        for (Cookie c : cookies){
            System.out.println(c.getName());
            if("lastTime".equals(c.getName())){
                System.out.println("fark");
                ok = true;
                String value = c.getValue();
                System.out.println("解码前：" + value);
                value = URLDecoder.decode(value,"utf-8");
//                System.out.println("解码后：" + value);
//                System.out.println("欢迎回来，你上一次访问的时间为：" + value);
                %>
                 <h1>欢迎回来，你上一次访问的时间为：<%=%>value%></h1>
                <%

                c.setValue(str_date);
                //设置cookie的存活时间
                c.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(c);
                break;
            }
        }
    }
    if(!ok){
    %>
    <h1>你好，欢迎首次访问</h1>
<%
        System.out.println("你好，欢迎首次访问");
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
    }

%>

</body>
</html>
