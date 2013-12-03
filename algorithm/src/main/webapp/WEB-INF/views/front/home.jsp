<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<title>主页</title>
<script type="text/javascript">
	function toDetail(id) {
		window.location.href = "/algorithm/front/detail/" + id;
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<div style="min-height: 400px;">
				<c:forEach items="${pagerJson.rows }" var="algorithm">
					<dl>
						<dt>
							<a href="javascript:toDetail(${algorithm.id })"
								data-role="button" data-mini="true">${algorithm.name }</a>
						</dt>
						<dd style="margin-top: 10px;">${algorithm.intro }</dd>
						<dd style="margin-top: 10px;">
							<span class="marks">3</span> <span style="margin-right: 30px;">下载次数：${algorithm.times }</span>
							<span style="margin-right: 30px;">上传者：${algorithm.user.username }</span>
							<span>上传时间：${algorithm.dateCreated }</span>
						</dd>
					</dl>
				</c:forEach>
			</div>
			<jsp:include page="/WEB-INF/views/front/inc/pager.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
	<script type="text/javascript">
		function topage(page) {
			window.location.href = "/home/front?page=" + page;
		}
	</script>
</body>
</html>
