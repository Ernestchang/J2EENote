<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div data-role="header">
	<div id="pagetop">
		<div id="sitenav">
			<ul>
				<c:if test="${empty loginUser}">
					<li>您还未登陆</li>
					<li><a id="homeBtnNav" href="/home/front" data-role="button" data-mini="true"
						data-inline="true" data-icon="home">主页</a></li>
					<li><a id="loginBtnNav" href="/auth/front/login" data-role="button"
						data-mini="true" data-inline="true">登陆</a></li>
					<li><a id="registerBtnNav" href="/user/front/register" data-role="button"
						data-mini="true" data-inline="true">注册</a></li>
				</c:if>
				<c:if test="${!empty loginUser }">
					<li><a id="homeBtnNav" href="/home/front" data-role="button" data-inline="true" data-mini="true" data-icon="home">主页</a></li>
					<li><a id="addQuestionBtnNav" href="/question/front/add" data-role="button" data-inline="true" data-mini="true">算法提问</a></li>
					<li><a id="addAlgorithmBtnNav" href="/algorithm/front/add" data-role="button" data-inline="true" data-mini="true">发布算法</a></li>
					<li>${loginUser.username }</li>
					<li><a id="logoutBtnNav" href="/auth/front/logout" data-role="button" data-inline="true" data-mini="true">安全退出</a></li>
				</c:if>
			</ul>
		</div>
		<div id="pageheader">
			<h1>
				算法<span>之家</span>
			</h1>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$("#searchBtn").click(function() {
		var con = $("#con").val();
		if(con.length > 0) {
			window.location.href="/algorithm/front/find/" + con + "?pcid=" + $("#pcid").val() + "&page=1"; 
		} else {
			alert("请输入查寻条件");
		}
	});
});
</script>
<div style="width: 1000px;height: 20px;margin: 0 auto;clear: both;">
	<div style="float: right;margin-left: 10px;">
	<input type="button" id="searchBtn" data-inline="true" data-mini="true" data-role="button" data-theme="a" value="搜索">
	</div>
	<div style="width: 200px;float: right;">
	<input type="hidden" id="pcid" value="${pcid }">
	<input type="search" data-inline="true" data-mini="true" id="con" value="${con }">
	</div>
</div>