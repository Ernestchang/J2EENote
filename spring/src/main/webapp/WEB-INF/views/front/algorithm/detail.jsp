<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/inc/head.jsp"></jsp:include>
<title>算法详细信息</title>
</head>
<body>
	<input type="hidden" id="id" value="${algorithm.id }" />
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/WEB-INF/views/front/inc/logo.jsp"></jsp:include>
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
	<jsp:include page="/WEB-INF/views/common/inc/foot.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/algorithm/detail.js"></script>
</body>
</html>