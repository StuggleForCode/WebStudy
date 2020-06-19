<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addProduct</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/addProductServlet" enctype="multipart/form-data">
        <table width="100%" align="center" bgcolor="#eeeeee" style="border:1px solid #8ba7e3">
            <tr><td align="center" bgcolor="afd1f3" colspan="4"><strong>添加商品</strong></td></tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">商品名称</td>
                <td><input type="text" name="name" class="bg"></td>
                <td align="center" bgcolor="#f5fafe">商品价格</td>
                <td><input type="text" name="price" class="bg"></td>
            </tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">商品数量</td>
                <td><input type="text" name="pnum" class="bg"></td>
                <td align="center" bgcolor="#f5fafe">商品类别</td>
                <td>
                    <select name="category">
                        <option value="" selected="selected">--选择商品类别--</option>
                        <option value="文学">文学</option>
                        <option value="生活">生活</option>
                        <option value="计算机">计算机</option>
                        <option value="外语">外语</option>
                        <option value="经管">经管</option>
                        <option value="励志">励志</option>
                        <option value="社科">社科</option>
                        <option value="学术">学术</option>
                        <option value="少儿">少儿</option>
                        <option value="艺术">艺术</option>
                        <option value="原版">原版</option>
                        <option value="科技">科技</option>
                        <option value="考试">考试</option>
                        <option value="生活百科">生活百科</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">商品图片：</td>
                <td><input type="file" name="upload" class="bg"></td>
            </tr>
            <tr>
                <td align="center" bgcolor="#f5fafe">商品描述</td>
                <td colspan="3"><textarea name="description" cols="30" rows="3" width=""96%></textarea></td>
            </tr>
            <tr>
                <td width="100%" align="center" colspan="4"><input type="submit" value="确定" class="bg"></td>
            </tr>

        </table>
    </form>
</body>
</html>
