<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>单文件上</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<center>
		<!--
			进行文件上传时，必须将表单的method属性设为post，将enctype属性设为moltipart/form-data
		-->
		--------------------------html----------------------------<br>
		<form action="upload1.action" method="post" enctype="multipart/form-data">
			username:<input type="text" name="username"><br>
			file:<input type="file" name="file"><br>
			<input type="submit" value="upload">
		</form>
		-------------------------struts2--------------------------<br>
		<s:form action="upload1" enctype="multipart/form-data">
			<s:textfield name="username" label="username"></s:textfield>
			<s:file name="file" label="file"></s:file>
			<s:submit value="upload"></s:submit>
		</s:form>
	</center>
	</body>
</html>