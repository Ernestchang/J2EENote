<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/common/css/uploadify.css" rel="stylesheet" />
<jsp:include page="/WEB-INF/views/common/inc/head.jsp"></jsp:include>
<title>申请版主</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/WEB-INF/views/front/inc/logo.jsp"></jsp:include>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title text-center">申请版主</h3>
			</div>
			<div class="panel-body">
				<form role="form" class="form-horizontal" id="applyForm" method="post">
					<div id="error_div" class="alert alert-danger alert-dismissable display-none">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<strong id="error">${error}</strong>
					</div>
					<div class="form-group">
						<label for="realname" class="col-md-2 col-xs-2 control-label">真实名字</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="realname" name="realname" autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="title" class="col-md-2 col-xs-2 control-label">职称</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="title" name="title">
						</div>
					</div>
					<div class="form-group">
						<label for="degree" class="col-md-2 col-xs-2 control-label">学位</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="degree" name="degree">
						</div>
					</div>
					<div class="form-group">
						<label for="summary" class="col-md-2 col-xs-2 control-label">个人简介</label>
						<div class="col-md-9 col-xs-9">
							<textarea class="form-control" id="summary" name="summary" placeholder="请填写个人简介" rows="4"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="channel1" class="col-md-2 col-xs-2 control-label">关注领域</label>
						<div class="col-md-3 col-xs-3">
							<select id="channel1" class="form-control">
								<option value="" selected="selected">请选择一级学科</option>
								<c:forEach items="${channels}" var="entry">
									<option value="${entry.id }">${entry.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select id="cid" name="cid" class="form-control">
								<option value="">请选择二级学科</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="approveName" class="col-md-2 col-xs-2 control-label">认证材料</label>
						<div class="col-md-7 col-xs-7" id="approveQueue">
							<input type="text" class="form-control" id="approveName" name="approveName" readonly="readonly" placeholder="请添加认证材料">
							<input type="hidden" class="form-control" id="approveHash" name="approveHash" value="">
						</div>
						<span id="approveUpload"></span>
					</div>
					<div class="form-group">
						<label for="vcode" class="col-md-2 col-xs-2 control-label">验证码</label>
						<div class="col-md-7 col-xs-7">
							<input type="text" class="form-control" id="vcode" name="vcode">
						</div>
						<img id="vcodeimg" src="${pageContext.request.contextPath }/verifycode/vcode" alt="验证码" class="img-rounded">
					</div>
					<button class="btn btn-lg btn-primary pull-right" type="submit">注册</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/inc/foot.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/user/apply.js"></script>
</body>
</html>