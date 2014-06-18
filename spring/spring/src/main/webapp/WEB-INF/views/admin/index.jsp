<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/common.css" rel="stylesheet" />
<title>admin首页</title>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath }/resources/common/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath }/resources/common/js/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">
		<ul class="list-inline">
			<li>${loginUser.username }</li>
			<li><a href="${pageContext.request.contextPath }/auth/logout">退出</a></li>
		</ul>
		<div class="row">
			<div class="col-md-2">
				<div id="leftMenu">
					<ul class="nav nav-pills nav-stacked navSelected">
						<h4>学科管理</h4>
						<li><a href="${pageContext.request.contextPath }/admin/channel/channels?cid=-1&level=1">学科管理</a></li>
					</ul>
					<ul class="nav nav-pills nav-stacked">
						<h4>用户管理</h4>
						<li><a href="#">版主管理</a></li>
						<li><a href="#">注册用户管理</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-10">内容</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery.bingoogol.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#leftMenu").bingoogol_accordion();
		});
	</script>
</body>
</html>
