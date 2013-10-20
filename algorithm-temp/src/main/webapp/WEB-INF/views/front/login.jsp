<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/resources/css/front/login.css">
<title>账户登录</title>
<script type="text/javascript" src="/resources/js/front/login.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<form id="login">
				<h1>账户登陆</h1>
				<input type="text" name="username" id="username" pattern="[A-z0-9]{5,15}"
					title="用户名由5到15位大小写字母和数字组成" placeholder="用户名" autofocus required>
				<input type="password" name="password" id="password" pattern="[A-z0-9]{5,15}"
					title="密码由5到15位大小写字母和数字组成" placeholder="密码" required>
				<input type="submit" data-role="button" data-theme="a" value="登陆">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
</body>
</html>
