<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>单文件上传结果</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<center>
		username:${requestScope.username }<br>
		fileFileName:${requestScope.fileFileName }<br>
		fileContentType:${requestScope.fileContentType }<br>
		----------------------------------------------------<br>
		username:<s:property value="username"/><br>
		fileFileName:<s:property value="fileFileName"/><br>
		fileContentType:<s:property value="fileContentType"/><br>
		</center>
	</body>
</html>