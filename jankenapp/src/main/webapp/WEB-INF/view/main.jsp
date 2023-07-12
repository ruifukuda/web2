
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Jyan" %>
<%
Jyan jyan = (Jyan)request.getAttribute("jyan"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Main" method="post">
<!-- <label>で範囲全部クリック対象になる -->
<label><input type="radio" name="hand" value="グー">グー</label>
<input type="radio" name="hand" value="チョキ">チョキ
<input type="radio" name="hand" value="パー">パー
<input type="submit" value="送信">
</form>
<%if(jyan !=null){ %>
<p>あなたは<%=jyan.getUserHand() %></p>
<p>PCは<%=jyan.getPcHand() %></p>
<p><%=jyan.getResult() %></p>
<a href="Main">retry!</a>
<%} %>
</body>
</html>