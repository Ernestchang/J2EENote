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
<title>用户列表</title>

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
				<h3 class="panel-title text-center">用户列表</h3>
			</div>
			<table class="table table-hover table-bordered table-condensed">
				<tr><th>用户名</th><th>邮箱</th><th colspan="2" class="text-center">操作</th></tr>
				<c:forEach items="${pagerJson.rows}" var="entry">
					<tr>
						<td>${entry.username }</td><td>${entry.email }</td><td><button type="button" class="btn btn-warning btn-sm">修改</button></td><td><button type="button" class="btn btn-danger btn-sm">删除</button></td>
					</tr>
				</c:forEach>
			</table>
				<ul class="pagination">
					<c:if test="${pagerJson.currentIndex == 1}">
						<li class="disabled"><span>首页</span></li>
						<li class="disabled"><span>上一页</span></li>
					</c:if>
					<c:if test="${pagerJson.currentIndex > 1}">
						<li><a href="javascript:topage(${1 })" title="1">首页</a></li>
						<li><a href="javascript:topage(${pagerJson.currentIndex - 1 })" title="${pagerJson.currentIndex - 1}">上一页</a>
						<li>
					</c:if>
					<c:forEach begin="${pagerJson.beginIndex}" end="${pagerJson.endIndex}" var="wp">
						<c:if test="${pagerJson.currentIndex == wp}">
							<li class="active"><span>${wp } <span class="sr-only">(current)</span></span></li>
						</c:if>
						<c:if test="${pagerJson.currentIndex != wp}">
							<li><a href="javascript:topage(${wp })" title="${wp}">${wp}</a>
							<li>
						</c:if>
					</c:forEach>
					<c:if test="${pagerJson.currentIndex < pagerJson.totalPage}">
						<li><a href="javascript:topage(${pagerJson.currentIndex + 1 })" title="${pagerJson.currentIndex + 1}">下一页</a>
						<li>
						<li><a href="javascript:topage(${pagerJson.totalPage })" title="${pagerJson.totalPage }">尾页</a></li>
					</c:if>
					<c:if test="${pagerJson.currentIndex == pagerJson.totalPage}">
						<li class="disabled"><span>下一页</span></li>
						<li class="disabled"><span>尾页</span></li>
					</c:if>
				</ul>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/user/list.js"></script>
</body>
</html>