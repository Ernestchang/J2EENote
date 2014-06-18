<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功页面</title>
</head>
<body>
	<center>
		username:${requestScope.username }<br>
		password:${requestScope.password }<br>
		<a href="${pageContext.request.contextPath }/testpermission!execute.action">测试权限execute</a>
		<a href="${pageContext.request.contextPath }/testpermission!myExecute.action">测试权限myExecute</a>
	</center>
</body>
</html>