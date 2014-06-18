<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<center>
	<form action="${pageContext.request.contextPath }/control/user/editUser.action" method="post" enctype="multipart/form-data">
		<input type="hidden" name="username" value="${sessionScope.user.username }">
		密码:<input type="password" name="password"><br>
		真名:<input type="text" name="realname"><br>
		头像:<input type="file" name="picture"><br>
		<input type="submit" value="提交">
	</form>
</center>
</body>
</html>