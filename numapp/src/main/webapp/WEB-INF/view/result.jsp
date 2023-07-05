<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.Num"%>
<%
Num num = (Num)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>入力された文字列</h1>
<p>
<%= num.getNumbers() %><br>
要素数:<%= num.getCount() %><br>
最大値:<%= num.getMaxNum() %><br>
最小値:<%= num.getMinNum() %><br>
合計:<%= num.getSum() %>
</p>
<a href="NumMain">戻る</a>
</body>
</html>