<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.wh.com" prefix="wh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>if</title>
</head>
<body>
<%
	session.setAttribute("user", "wanghao");
%>
<wh:choose>
	<wh:when test="${user != null }">
		已登陆
	</wh:when>
	<wh:otherwise>
		还没登录
	</wh:otherwise>
</wh:choose>
</body>
</html>