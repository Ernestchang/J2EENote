<%@ page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>斯蒂芬斯蒂芬森的</h1>
	<div style="border: 1px solid red;width: 800px;">
		${word }
	</div>
</body>