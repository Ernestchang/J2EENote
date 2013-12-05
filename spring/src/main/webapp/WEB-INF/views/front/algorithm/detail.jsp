<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/common/css/uploadify.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/common.css" rel="stylesheet" />
<title>算法详细信息</title>

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
	<input type="hidden" id="id" value="${algorithm.id }" />
	<div class="container">
		<div id="error_div" class="alert alert-danger alert-dismissable display-none">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<strong id="error">${error}</strong>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title text-center">${algorithm.name }-详细信息</h3>
			</div>
			<div class="panel-body">
				<span>价格：${algorithm.price }</span>
				<button type="button" id="buyBtn" class="btn btn-md btn-primary">购买</button>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-body">
				<iframe src="http://docs.google.com/viewer?url=${docUrl }&embedded=true" width="100%" height="780" style="border: none;"></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/algorithm/detail.js"></script>
</body>
</html>