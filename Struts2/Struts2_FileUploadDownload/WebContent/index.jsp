<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传下载</title>
</head>
<body>
	<center>
	<h1>文件上传下载</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath}/upload/upload1.jsp">单文件文件上传</a></li>
		<li><a href="${pageContext.request.contextPath}/upload/upload2.jsp">指定多文件上传</a></li>
		<li><a href="${pageContext.request.contextPath}/upload/upload3.jsp">自定义上传文件个数</a></li>
		<li><a href="${pageContext.request.contextPath}/download.action">文件下载</a></li>
	</ul>
	</center>
</body>
</html>