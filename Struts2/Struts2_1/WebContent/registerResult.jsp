<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<center>
		<h2><font>注册成功</font></h2>
			username:<s:property value="username"/><br>
			password:<s:property value="password"/><br>
			age:<s:property value="age"/><br>
			birthday:<s:property value="birthday"/><br>
			graduation:<s:property value="graduation"/><br>
	</center>
</body>
</html>