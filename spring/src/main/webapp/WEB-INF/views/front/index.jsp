<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/common.css" rel="stylesheet" />
<title>front首页</title>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath }/resources/common/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath }/resources/common/js/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">
		<ul class="list-inline">
			<c:if test="${empty loginUser}">
				<li><a href="${pageContext.request.contextPath }/auth/login">登陆</a></li>
				<li><a href="${pageContext.request.contextPath }/front/user/register">注册</a></li>
			</c:if>
			<c:if test="${!empty loginUser }">
				<li>${loginUser.username }</li>
				<li><a href="${pageContext.request.contextPath }/auth/logout">退出</a></li>
			</c:if>
		</ul>
		<div class="panel panel-success" style="margin-top: 10px;">
			<div class="panel-heading">
				<h3 class="panel-title">front首页</h3>
			</div>
			<div class="panel-body">
				<ol>
					<li><a href="#">呵呵</a></li>
				</ol>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>

</body>
</html>
