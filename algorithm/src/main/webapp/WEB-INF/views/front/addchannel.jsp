<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/resources/css/front/addchannel.css">
<title>添加分类</title>
<script type="text/javascript" src="/resources/js/front/addchannel.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<form id="addchannel">
				<h1>添加分类</h1>
				<select id="pid1">
					<option value="" selected="selected">请选择一级所属方向</option>
					<c:forEach items="${topChannels }" var="topChannel">
						<option value="${topChannel.id }">${topChannel.name }</option>
					</c:forEach>
				</select> <select id="pid2" name="pid">
					<option value="" selected="selected">请选择二级所属方向</option>
				</select> 
				<input name="name" type="text" title="请填写分类名称" placeholder="分类名称" required> 
				<input type="submit" data-role="button" data-theme="a" value="提交">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
</body>
</html>
