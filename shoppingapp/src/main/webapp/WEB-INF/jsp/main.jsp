<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product, java.util.List" %>
<%
List<Product> productList =
	(List<Product>)application.getAttribute("productList");
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お買い物</title>
</head>
<body>
<% if(msg != null){ %>
	<p><%= msg %></p>
<% } %>
<p>商品を登録してください。</p>
<form action="Main" method="post">
<p>製品名:</p>
<p><input type="text" name="name"></p>
<p>価格:</p>
<p><input type="number" name="price"></p>
<p><input type="submit" value="登録"></p>
</form>
<% if(productList.size() != 0 ){ %>
	<table border="1">
	<tr>
		<th>製品名</th>
		<th>価格</th>
		<th>登録日</th>
	</tr>
	<% for(Product product: productList){ %>
		<tr>
			<td><%= product.getName()%></td>	
			<td><%= product.getPrice()%></td>	
			<td><%= product.getDate()%></td>	
		</tr>
	<% } %>
	</table>
<% } %>
</body>
</html>