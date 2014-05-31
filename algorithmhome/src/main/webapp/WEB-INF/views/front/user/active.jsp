<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/inc/head.jsp"></jsp:include>
<title>账户激活</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/WEB-INF/views/front/inc/logo.jsp"></jsp:include>
		<div class="panel panel-success" style="margin-top: 10px;">
			<div class="panel-heading">
				<h3 class="panel-title">账户激活</h3>
			</div>
			<div class="panel-body">
				${msg }<a href="${pageContext.request.contextPath }/user/resendemail/${id}">重新发送激活码</a>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/inc/foot.jsp"></jsp:include>
</body>
</html>
