<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LIHAO1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>潜在用户网络调查</h1>
    <form action="/LIHAO1767159234/LIHAOServlet" method = "post">
    	
    	<div>
    		姓名：<input type = "text" name = "lhname"/>
    	</div>
    	
    	<div>
    		Email：<input type = "email" name = "lhemail"/>
    	</div>
    	<div>
    		年纪：<input type = "radio" name = "lhage" value = "小于18"/>小于18
    		<input type = "radio" name = "lhage" value = "18-25"/>18-25
    		<input type = "radio" name = "lhage"  value = "26-40"/>26-40
    		<input type = "radio" name = "lhage" value = "大于40"/>大于40
    	</div>
    	
    	<div>
    		编程时间：
    		<select name = "lhtime">
    			<option value = "1-2年">1-2年</option>
    			<option value = "2-3年">2-3年</option>
    			<option value = "3-4年">3-4年</option>
    			<option value = "4年以上">4年以上</option>
    		</select>
    	</div>
    	
    	<div>
    		使用的操作系统：
    		<select multiple="multiple" size="5" name="lhOs">
	            <option value="WinXP">WinXP</option>
	            <option value="Win2000">Win2000</option>
	            <option value="FreeBSO">FreeBSO</option>
	            <option value="MacOs">MacOs</option>
	            <option value="Others">Others</option>
       		 </select>
    	</div>
    	
    	<div>
    		使用的编程语言：
    		<input type="checkbox" name="lhLanguage" value="C">C
	        <input type="checkbox" name="lhLanguage" value="C++">C++
	        <input type="checkbox" name="lhLanguage" value="C#">C#
	        <input type="checkbox" name="lhLanguage" value="Python">Python
	        <input type="checkbox" name="lhLanguage" value="Java">Java
	        <input type="checkbox" name="lhLanguage" value="VB">VB
    	</div>
    	
    	<div>
	    	 建议:
		        <textarea name="lhAdvice">
		       		 我很喜欢编程！
			       	我也很喜欢交流!
		        </textarea>
			       	
    	</div>
    	
    	<div><input type = "submit" value = "提交" /></div>
    
    </form>
  </body>
</html>
