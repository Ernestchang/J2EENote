<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/common/css/uploadify.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/common/css/common.css" rel="stylesheet" />
<title>发布算法</title>

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
				<h3 class="panel-title text-center">发布算法</h3>
			</div>
			<div class="panel-body">
				<form role="form" class="form-horizontal" id="addForm">
					<div id="error_div" class="alert alert-danger alert-dismissable display-none">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<strong id="error">${error}</strong>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-2 col-xs-2 control-label">算法名称</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="name" name="name" placeholder="请填写算法名称" autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="attach" class="col-md-2 col-xs-2 control-label">附件</label>
						<div class="col-md-7 col-xs-7" id="some_file_queue">
							<input type="text" class="form-control" id="attach" name="attach" readonly="readonly" placeholder="附件"> <input type="hidden" class="form-control" id="key" name="key" value="">
						</div>
						<span id="file_upload"></span>
					</div>
					<div class="form-group">
						<label for="channel1" class="col-md-2 col-xs-2 control-label">所属学科</label>
						<div class="col-md-3 col-xs-3">
							<select id="channel1">
								<option value="" selected="selected">请选择一级学科</option>
								<c:forEach items="${channels}" var="entry">
									<option value="${entry.id }">${entry.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select id="channel2">
								<option value="">请选择二级学科</option>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select id="cid" name="cid">
								<option value="">请选择三级学科</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="vcode" class="col-md-2 col-xs-2 control-label">验证码</label>
						<div class="col-md-7 col-xs-7">
							<input type="text" class="form-control" id="vcode" name="vcode">
						</div>
						<img id="vcodeimg" src="${pageContext.request.contextPath }/verifycode/vcode" alt="验证码" class="img-rounded">
					</div>
					<button class="btn btn-lg btn-primary pull-right" type="submit">发布</button>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/common/js/jquery.uploadify.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/algorithm/add.js"></script>
</body>
</html>