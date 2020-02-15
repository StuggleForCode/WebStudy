
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <% String lhname = (String) request.getSession().getAttribute("lhname");
    %>
    <% String lhemail =(String) request.getSession().getAttribute("lhemail");   %>

    <% String lhage =(String) request.getSession().getAttribute("lhage");   %>
    <% String lhtime =(String) request.getSession().getAttribute("lhtime");   %>
    <% String[] lhOs = (String[]) request.getSession().getAttribute("lhOs");   %>
    <% String[] lhlanguages = (String[]) request.getSession().getAttribute("lhLanguage");   %>
    <% String lhadvice =(String) request.getSession().getAttribute("lhAdvice");   %>
</head>
<body>
	姓名：<%= lhname%> <br>
	邮箱：<%= lhemail%> <br>
	年龄：<%= lhage%> <br>
	编程时间：<%= lhtime%> <br>
	操作系统：<c:forEach items="${lhOs}" var="os" >
	
		${os}
	
	</c:forEach>
	<br>
	
	编程语言：<c:forEach items="${lhlanguages}" var="language" >
	
	    ${language}
	
	</c:forEach>
	 <br>
	
	
	建议：<%= lhadvice%> <br>

</body>
</html>
