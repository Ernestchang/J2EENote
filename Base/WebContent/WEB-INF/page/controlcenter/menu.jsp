<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.wh.com/base" prefix="base"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base target="content"/>
		<style type="text/css">
			body {
				background-color: #cf9;
			}
		</style>
	</head>
	<body>
		<center>
		<table border="1">
			<tr><th>娱乐</th></tr>
			<base:permission privilege="view" module="topical">
			<tr><td><a href="${pageContext.request.contextPath }/control/message/listTopical.action">说说列表</a></td></tr>
			</base:permission>
			
			<tr><td><a href="${pageContext.request.contextPath }/control/message/addTopicalUI.action">发表说说</a></td></tr>
			
		</table><br>
		<script type="text/javascript">
		window.onload = function() {
			var table = document.getElementById("t1");
			var trs = table.getElementsByTagName("tr");
			if(trs.length == 1) {
				table.style.display="none";
			}
		};
			
		</script>
		<table border="1" id="t1">
			<tr><th>用户管理</th></tr>
			<base:permission privilege="view" module="user">
			<tr><td><a href="${pageContext.request.contextPath }/control/user/listUser.action">用户列表</a></td></tr>
			</base:permission>
			<base:permission privilege="insert" module="user">
			<tr><td><a href="${pageContext.request.contextPath }/control/user/addUserUI.action">添加用户</a></td></tr>
			</base:permission>
			<base:permission privilege="update" module="user">
			<tr><td><a href="${pageContext.request.contextPath }/control/user/editUserUI.action">修改用户</a></td></tr>
			</base:permission>
		</table>
		</center>
	</body>
</html> 