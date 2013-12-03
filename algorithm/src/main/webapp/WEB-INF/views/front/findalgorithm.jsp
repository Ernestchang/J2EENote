<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<title>主页</title>
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
							<a href="" data-role="button" data-mini="true">${algorithm.name }</a>
						</dt>
						<dd style="margin-top: 10px;">${algorithm.intro }d历史角度考虑房价是独立开发建设拉开大家反抗螺丝钉棵老树简单快乐粉丝</dd>
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
			window.location.href="/algorithm/front/find/" + $("#con").val() + "?pcid=" + $("#pcid").val() + "&page=" + page;
		}
	</script>
</body>
</html>
