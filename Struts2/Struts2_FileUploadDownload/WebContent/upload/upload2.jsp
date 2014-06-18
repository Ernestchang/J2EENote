<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>多文件上传</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<center>
		<!--
			这几个name必须是一样的
		-->
		<s:fielderror cssStyle="color:red"/>
		<form action="upload2.action" method="post" enctype="multipart/form-data">
			username:<input type="text" name="username"><br>
			file1:<input type="file" name="file"><br>
			file2:<input type="file" name="file"><br>
			file3:<input type="file" name="file"><br>
			<input type="submit" value="upload">
		</form>
		</center>
	</body>
</html>