<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html>
<head>
    <title>home</title>
</head>
<body>
<%--    <h3>主体信息</h3>--%>

    <%
        pageContext.setAttribute("msg", "hello");
    %>


    <%
        Object msg = pageContext.getAttribute("msg");
        System.out.println(msg);
        /**
         * pageContext  PageContext
         * request  HttpServletRequest
         * session  HttpServletSession
         * application  ServletContext
         * response HttpServletResponse
         * page     Object
         * out      JSPWriter
         * config   ServletConfig
         * exception Throwable
         */

    %>



</body>
</html>
