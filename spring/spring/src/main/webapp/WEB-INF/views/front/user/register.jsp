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
<title>用户注册</title>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath }/resources/common/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath }/resources/common/js/respond.min.js"></script>
<![endif]-->

<style type="text/css">
</style>
</head>

<body>
	<input type="hidden" id="ctx" value="${pageContext.request.contextPath }" />
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title text-center">用户注册</h3>
			</div>
			<div class="panel-body">
				<form role="form" class="form-horizontal" id="registerForm" method="post">
					<div id="error_div" class="alert alert-danger alert-dismissable display-none">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<strong id="error">${error}</strong>
					</div>
					<div class="form-group">
						<label for="username" class="col-md-2 col-xs-2 control-label">用户名</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="username" name="username" autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 col-xs-2 control-label">密码</label>
						<div class="col-md-9 col-xs-9">
							<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="form-group">
						<label for="vpassword" class="col-md-2 col-xs-2 control-label">确认密码</label>
						<div class="col-md-9 col-xs-9">
							<input type="password" class="form-control" id="vpassword" name="vpassword">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-2 col-xs-2 control-label">邮箱</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="email" name="email">
						</div>
					</div>
					<div class="form-group">
						<label for="channel1" class="col-md-2 col-xs-2 control-label">关注领域</label>
						<div class="col-md-3 col-xs-3">
							<select id="channel1">
								<option value="" selected="selected">请选择一级学科</option>
								<c:forEach items="${channels}" var="entry">
									<option value="${entry.id }">${entry.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select id="channel2">
								<option value="">请选择二级学科</option>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select id="cid" name="cid">
								<option value="">请选择三级学科</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="vcode" class="col-md-2 col-xs-2 control-label">验证码</label>
						<div class="col-md-7 col-xs-7">
							<input type="text" class="form-control" id="vcode" name="vcode">
						</div>
						<img id="vcodeimg" src="${pageContext.request.contextPath }/verifycode/vcode" alt="验证码" class="img-rounded">
					</div>
					<button class="btn btn-lg btn-primary pull-right" type="submit">注册</button>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/user/register.js"></script>
</body>
</html>