<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name}" />さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg }">
	<p><c:out value="${errorMsg }" /></p>
</c:if>
<c:if test="${not empty mutterList }">
	<table border = "1">
	<tr>
	<th>ユーザー名</th>
	<th>つぶやき</th>
	</tr>
	<c:forEach var="mutter" items="${mutterList }">
		<tr>
			<td><c:out value="${mutter.userName }" /></td>
			<td><c:out value="${mutter.userText }" /></td>
			<c:if test="${mutter.userName eq loginUser.name }">
				<td><a href="/dokoTsubuDB/Update?id=${mutter.id }">更新</a></td>
				<td><a href="/dokoTsubuDB/Delete?id=${mutter.id }">削除</a></td>
			</c:if>
		</tr>
	</c:forEach>
	</table>
</c:if>
<jsp:include page="footer.jsp" />
</body>
</html>