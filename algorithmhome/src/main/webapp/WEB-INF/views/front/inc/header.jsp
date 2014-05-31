<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input type="hidden" id="ctx" value="${pageContext.request.contextPath }" />
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${pageContext.request.contextPath }/front/index">算法之家</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="${pageContext.request.contextPath }/front/index">主页</a></li>
			<li><a href="${pageContext.request.contextPath }/algorithm/auth/publish">发布算法</a></li>
			<li><a href="#">所有算法</a></li>
			<li><a href="#">算法提问</a></li>
			<li><a href="#">关于我们</a></li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">搜索</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty loginUser}">
				<li><a href="${pageContext.request.contextPath }/login/login">登陆</a></li>
				<li><a href="${pageContext.request.contextPath }/user/register">注册</a></li>
			</c:if>
			<c:if test="${!empty loginUser }">
				<c:if test="${loginUser.type ==3 }">
					<li><a href="${pageContext.request.contextPath }/algorithm/auth/publish">发布算法</a></li>
					<li><a href="${pageContext.request.contextPath }/user/auth/apply">申请版主</a></li>
				</c:if>
				<li><a href="javascript:void(0)">${loginUser.username }</a></li>
				<li><a href="${pageContext.request.contextPath }/login/logout">退出</a></li>
			</c:if>
		</ul>
	</div>
</nav>