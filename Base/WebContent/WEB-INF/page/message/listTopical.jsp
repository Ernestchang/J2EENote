<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
	<h3>说说列表</h3>
	<ul>
	<c:forEach var="topical" items="${requestScope.topicallist }">
		<li>${topical.content }</li>
	</c:forEach>
	</ul>
	</center>
</body>
</html>