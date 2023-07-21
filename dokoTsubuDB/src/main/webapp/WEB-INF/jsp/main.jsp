<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
List<Mutter> mutterList = 
		(List<Mutter>)request.getAttribute("mutterList");
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% if(mutterList.size() > 0){ %>
	<table border = "1">
	<tr>
	<th>ユーザー名</th>
	<th>つぶやき</th>
	</tr>
	<% for(Mutter mutter : mutterList){ %>
		<tr>
			<td><%= mutter.getUserName() %></td>
			<td><%= mutter.getUserText() %></td>
			<% if(mutter.getUserName().equals(loginUser.getName())){ %>
				<td><a href="/dokoTsubuDB/Update?id=<%=mutter.getId() %>">更新</a></td>
				<td><a href="/dokoTsubuDB/Delete?id=<%=mutter.getId() %>">削除</a></td>
			<% } %>
		</tr>
	<% } %>
	</table>
<% } %>
</body>
</html>