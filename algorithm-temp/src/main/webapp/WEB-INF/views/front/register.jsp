<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/resources/css/front/register.css">
<title>账户注册</title>
<script type="text/javascript" src="/resources/js/front/register.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<form id="register">
				<h1>账户注册</h1>
					<input type="hidden" id="isAvaliable" value="false"> <input
						id="username" name="username" type="text" pattern="[A-z0-9]{5,15}"
						title="用户名由5到15位大小写字母和数字组成" placeholder="用户名" autofocus required>
					<input name="password" type="password" pattern="[A-z0-9]{5,15}"
						title="密码由5到15位大小写字母和数字组成" placeholder="密码" required> <input
						name="confirmPwd" type="password" pattern="[A-z0-9]{5,15}"
						title="密码由5到15位大小写字母和数字组成" placeholder="确认密码" required> <input
						name="email" type="email" placeholder="邮箱" required> <select
						id="pcid">
						<option value="" selected="selected">请选择一级研究方向</option>
						<c:forEach items="${topChannels }" var="topChannel">
							<option value="${topChannel.id }">${topChannel.name }</option>
						</c:forEach>
					</select> <select id="cid" name="cid">
						<option value="" selected="selected">请选择二级研究方向</option>
					</select>
					<input type="submit" value="注册" data-role="button" data-theme="a">
					
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
</body>
</html>
