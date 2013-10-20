<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/views/front/inc/head.jsp"></jsp:include>
<style type="text/css">
#wordcontent {
	background-color: white;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
	border-style: dashed;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-width: 1px;
	padding: 24px;
	border-bottom-right-radius: 0px;
	border-style: dashed;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-width: 6px;
	padding: 48px;
	border-style: dashed;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-width: 1px;
	padding: 24px;
	width: 550px;
}
#downloadThesisBtn {
	margin-left: 150px;
}
#downloadAlgorithmBtn {
	margin-left: 20px;
}
</style>
<title>算法详细信息</title>
<script type="text/javascript" src="/resources/js/front/detailalgorithm.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div data-role="content" id="content">
		<jsp:include page="/WEB-INF/views/front/inc/sidebar.jsp"></jsp:include>
		<div id="main">
			<div>
				<dl>
					<dt>
						<h3 align="center">${algorithm.name }</h3>
						<input type="hidden" id="aid" value="${algorithm.id }">
						<input type="hidden" id="ascore" value="${algorithm.score }">
					</dt>
					<dd>${algorithm.intro }d历史角度考虑房价是独立开发建设拉开大家反抗螺丝钉棵老树简单快乐粉丝</dd>
					<dd style="margin-top: 10px;">
						<span class="marks">${algorithm.score }</span> <span style="margin-right: 30px;">下载次数：${algorithm.times }</span>
						<span style="margin-right: 30px;">上传者：${algorithm.user.username }</span>
						<span>上传时间：${algorithm.dateCreated }</span>
					</dd>
					<dd>
						<a id=downloadThesisBtn href="/home/front" target="_blank"
							data-role="button" data-inline="true">下载论文</a>
						<a id=downloadAlgorithmBtn href="/home/front" target="_blank"
							data-role="button" data-inline="true">下载算法</a>
					</dd>
				</dl>
			</div>
			<div id="wordcontent">${word }</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front/inc/footer.jsp"></jsp:include>
</body>
</html>
