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
						<label for="summary" class="col-md-2 col-xs-2 control-label">算法简介</label>
						<div class="col-md-9 col-xs-9">
							<textarea class="form-control" id="summary" name="summary" placeholder="请填写算法简介" rows="4"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="author1" class="col-md-2 col-xs-2 control-label">第一作者</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="author1" name="author1" placeholder="请填写第一作者">
						</div>
					</div>
					<div class="form-group">
						<label for="author2" class="col-md-2 col-xs-2 control-label">第二作者</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="author2" name="author2" placeholder="请填写第三作者">
						</div>
					</div>
					<div class="form-group">
						<label for="author3" class="col-md-2 col-xs-2 control-label">第三作者</label>
						<div class="col-md-9 col-xs-9">
							<input type="text" class="form-control" id="author3" name="author3" placeholder="请填写第三作者">
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-md-2 col-xs-2 control-label">算法价格</label>
						<div class="col-md-3 col-xs-3">
							<input type="text" class="form-control" id="price" value="5" name="price" readonly="readonly">
						</div>
						<div class="col-md-6 col-xs-6">
							<input type="range"  id="pricerange" value="5" min="0" max="100" class="form-control" >
						</div>
					</div>
					<div class="form-group">
						<label for="channel1" class="col-md-2 col-xs-2 control-label">所属学科</label>
						<div class="col-md-3 col-xs-3">
							<select class="form-control" id="channel1">
								<option value="" selected="selected">请选择一级学科</option>
								<c:forEach items="${channels}" var="entry">
									<option value="${entry.id }">${entry.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select class="form-control" id="channel2">
								<option value="">请选择二级学科</option>
							</select>
						</div>
						<div class="col-md-3 col-xs-3">
							<select class="form-control" id="cid" name="cid">
								<option value="">请选择三级学科</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="codeName" class="col-md-2 col-xs-2 control-label">算法源码</label>
						<div class="col-md-7 col-xs-7" id="codeQueue">
							<input type="text" class="form-control" id="codeName" name="codeName" readonly="readonly" placeholder="算法源码">
							<input type="hidden" class="form-control" id="codeHash" name="codeHash" value="">
						</div>
						<span id="codeUpload"></span>
					</div>
					<div class="form-group">
						<label for="iodataName" class="col-md-2 col-xs-2 control-label">输入输出</label>
						<div class="col-md-7 col-xs-7" id="iodataQueue">
							<input type="text" class="form-control" id="iodataName" name="iodataName" readonly="readonly" placeholder="输入输出">
							<input type="hidden" class="form-control" id="iodataHash" name="iodataHash" value="">
						</div>
						<span id="iodataUpload"></span>
					</div>
					<div class="form-group">
						<label for="thesisName" class="col-md-2 col-xs-2 control-label">论文</label>
						<div class="col-md-7 col-xs-7" id="thesisQueue">
							<input type="text" class="form-control" id="thesisName" name="thesisName" readonly="readonly" placeholder="论文">
							<input type="hidden" class="form-control" id="thesisHash" name="thesisHash" value="">
						</div>
						<span id="thesisUpload"></span>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/front/js/algorithm/publish.js"></script>
</body>
</html>