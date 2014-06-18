<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
			body {
				background-color: #9c6;
			}
		</style>
	</head>
	<body>
		<center>
		<img width="20px" height="20px" alt="头像" src="${sessionScope.user.imageFullPath }">  ${sessionScope.user.realname }
		<a target="_top" href="${pageContext.request.contextPath }/logout.action">安全退出</a>
		</center>
	</body>
</html> 