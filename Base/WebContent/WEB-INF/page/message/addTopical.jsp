<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
	<h1>发表说说</h1>
	<form action="${pageContext.request.contextPath }/control/message/addTopical.action" method="post">
	内容:<input type="text" name="content"><br>
	<s:token></s:token>
	<input type="submit" value="发表">
	</form>
	</center>
</body>
</html>