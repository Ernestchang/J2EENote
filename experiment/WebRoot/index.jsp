<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>综合性、设计性实验项目鉴定</title>
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var information = $("#information").text();
				if(information) {
					alert(information);
				}
				$("#loginForm").submit(function() {
					var userid = $("#index_username").val();
					var password = $("#index_password").val();
					var cmd = $("#loginForm input:radio:checked").val();
					var useridReg = /^[0-9]{10}$/;
					var passwordReg = /^[a-zA-Z0-9]{6,15}$/;
					var boolean_userid = useridReg.test(userid);
					var boolean_password = passwordReg.test(password);
					if(!(cmd && boolean_userid && boolean_password)) {
						if(!boolean_userid) {
							alert("用户名必须是10位数字");
						} else if(!boolean_password) {
							alert("密码必须是6-15位字母或数字组成");
						} else if(!cmd) {
							alert("请选择用户类型");
						}
						return false;
					}
					return true;
				});
			});
		</script>
		<script type="text/javascript" src="js/index.js"></script>
	</head>
	
	<body>
		<%--登陆失败信息 --%>
		<label id="information" style="display: none;">${information }</label>
		<%--顶部 --%>
		<div class="index_top"></div>
		<%--中部 --%>
		<div class="index_center">
			<form action="${pageContext.request.contextPath }/LoginServlet" method="post" id="loginForm">
				<input type="text" name="userid" id="index_username">
				<input type="password" name="password" id="index_password">
				<div class="index_radio">
					<input id="cmd1" name="cmd" type="radio" value="kczz">
					<label for="cmd1">课程组长</label>
					<input id="cmd2" name="cmd" type="radio" value="syls">
					<label for="cmd2">实验老师</label>
					<input id="cmd3" name="cmd" type="radio" value="pszj">
					<label for="cmd3">评审专家</label>
					<input id="cmd4" name="cmd" type="radio" value="gzry">
					<label for="cmd4">工作人员</label>
				</div>
				<input type="submit" class="index_submit" value="" onFocus="this.blur()">
				<input type="reset" class="index_reset" value="" onFocus="this.blur()">
			</form>
		</div>
		<%--底部 --%>
		<jsp:include page="/WEB-INF/page/common/bottom.jsp"></jsp:include>
	</body>
</html>