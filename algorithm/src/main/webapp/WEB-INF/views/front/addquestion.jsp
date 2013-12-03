<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/resources/css/front/addquestion.css">
<title>算法提问</title>
<script type="text/javascript" src="/resources/js/front/addquestion.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<form id="addquestion">
				<h1>算法提问</h1>
				<input name="title" type="text" title="请填写问题名称" placeholder="问题名称"
					autofocus required> <input name="intro" type="text"
					title="请填写问题描述" placeholder="问题描述" required> <select
					id="score" name="score">
					<option value="" selected="selected">请选择标价</option>
					<c:forEach begin="1" end="10" varStatus="status">
						<option value="${status.count }">${status.count }</option>
					</c:forEach>
				</select> <select id="pcid1">
					<option value="" selected="selected">请选择一级所属方向</option>
					<c:forEach items="${topChannels }" var="topChannel">
						<option value="${topChannel.id }">${topChannel.name }</option>
					</c:forEach>
				</select> <select id="pcid2">
					<option value="" selected="selected">请选择二级所属方向</option>
				</select> <select id="cid" name="cid">
					<option value="" selected="selected">请选择三级级所属方向</option>
				</select>
				<a href="/channel/front/add">没有想要的分类？添加三级分类</a>
				<input type="submit" data-role="button" data-theme="a" value="提交">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
</body>
</html>
