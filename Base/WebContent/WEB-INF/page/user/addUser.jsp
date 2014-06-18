<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<center>
	<h1>添加用户</h1>
	<form action="${pageContext.request.contextPath }/control/user/addUser.action" method="post">
	用户名:<input type="text" name="username"><br>
	密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"><br>
	确&nbsp;&nbsp;&nbsp;&nbsp;认:<input type="password" name="confirm"><br>
	真&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="realname"><br>
	<input type="submit" value="添加">
	</form>
	</center>
</body>
</html>