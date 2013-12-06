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
<title>未审核的版主列表</title>

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
				<h3 class="panel-title text-center">未审核的版主列表</h3>
			</div>
			<table class="table table-hover table-bordered table-condensed">
				<tr><th>用户名</th><th>板块名</th><th colspan="2" class="text-center">操作</th></tr>
				<c:forEach items="${list}" var="entry">
					<tr>
						<td><a target="_blank" href="#">${entry.username }</a></td>
						<td><a target="_blank" href="#">${entry.cname }</a></td>
						<td><button type="button" onclick="javascript:changeStatus('${entry.uid}',2)" class="btn btn-success btn-sm">标记为通过</button></td>
						<td><button type="button" onclick="javascript:changeStatus('${entry.uid}',3)" class="btn btn-primary btn-sm">标记为未通过</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/admin/js/moderator/notvertifylist.js"></script>
</body>
</html>