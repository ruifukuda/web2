<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Mutter"%>
<%
Mutter mutter = (Mutter)request.getAttribute("mutter");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<form action="/dokoTsubuDB/Update" method="post">
つぶやき:<input type="text" name="text" value="<%=mutter.getUserText() %>"><br>
<input type="hidden" name="userName" value="<%=mutter.getUserName() %>"><br>
<input type="hidden" name="id" value="<%=mutter.getId() %>"><br>
<button type="submit">更新</button>
</form>
</body>
</html>