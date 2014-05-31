<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/inc/head.jsp"></jsp:include>
<title>二级算法列表</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/WEB-INF/views/front/inc/logo.jsp"></jsp:include>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title text-center">二级算法列表</h3>
			</div>
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<c:forEach items="${channel2s }" var="entry">
						<li><a href="${pageContext.request.contextPath }/algorithm/detail/${entry.id}">${entry.name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/inc/foot.jsp"></jsp:include>
</body>
</html>