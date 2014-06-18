<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">
	function refreshCode() {
		var img = document.getElementById("imgCode");
		//每次访问地址都不一样，因为有随机数
		img.src="${pageContext.request.contextPath }/code.action?tag=" + Date.parse(new Date());
	}
</script>
</head>
<body>
	<center>
	<h3>${requestScope.message }</h3>
	<h1>用户登录</h1>
	<form action="${pageContext.request.contextPath }/login.action" method="post" onsubmit="document.getElementById('sub').disabled=true" target="_top">
		用户名：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		验证码：<input type="text" name="checkcode" style="width:150px;height:20px;">
			<img  id="imgCode" src="${pageContext.request.contextPath }/code.action">
			<a href="javascript:refreshCode()">换一张</a>
		<input type="submit" value="登录" id="sub">
	</form>
	</center>
</body>
</html>