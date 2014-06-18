<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<center>
	<h2>用户列表</h2>
	<table border='1'>
		<tr><th>用户名</th><th>真名</th><th>删除</th></tr>
		<c:forEach var="user" items="${requestScope.userlist }">
			<tr>
				<td>${user.username }</td>
				<td>${user.realname }</td>
				<td><a href="${pageContext.request.contextPath }/control/user/deleteUser.action?username=${user.username }">删除用户</a></td>
			</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>