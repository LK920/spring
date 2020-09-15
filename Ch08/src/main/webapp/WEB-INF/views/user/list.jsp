<%@ page contentType="text/html;charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h4>사용자 목록</h4>
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
			<c:forEach var = "user" items = "${users }">
			<tr>
				<th>${user.uid}</th>
				<th>${user.name}</th>
				<th>${user.hp}</th>
				<th>${user.age}</th>
				<th>
					<a href="/ch08/user/modify?uid=${user.uid}">수정</a>
					<a href="/ch08/user/delete?uid=${user.uid}">삭제</a>
				</th>
			</tr>
			</c:forEach>
		</table>
</body>
</html>