<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<center>
		<h2><font>用户注册</font></h2>
		<s:actionerror cssStyle="color:red"/>
		-------------------------------------
		<s:fielderror cssStyle="color:blue"/>
		<!-- 
		<form action="register.action">
			username:<input type="text" name="username" size="20"><br>
			password:<input type="password" name="password" size="20"><br>
			repassword:<input type="password" name="repassword" size="20"><br>
			age:<input type="text" name="age" size="20"><br>
			birthday:<input type="text" name="birthday" size="20"><br>
			graduation:<input type="text" name="graduation" size="20"><br>
			<input type="submit" value="submit"><br>
		</form>
		 -->
		<!-- 
		<s:form action="register.action" theme="simple">
			<s:textfield name="username" label="username"></s:textfield>
			<s:password name="password" label="password"></s:password>
			<s:password name="repassword" label="repassword"></s:password>
			<s:textfield name="age" label="age"></s:textfield>
			<s:textfield name="birthday" label="birthday"></s:textfield>
			<s:textfield name="graduation" label="graduation"></s:textfield>
			<s:submit value="submit"></s:submit>
		</s:form>
		-->
		<s:form action="register.action" theme="simple">
			username:<s:textfield name="username"></s:textfield><br>
			password:<s:password name="password"></s:password><br>
			repassword:<s:password name="repassword"></s:password><br>
			age:<s:textfield name="age"></s:textfield><br>
			birthday:<s:textfield name="birthday"></s:textfield><br>
			graduation:<s:textfield name="graduation"></s:textfield><br>
			<s:submit value="submit"></s:submit>
		</s:form>
	</center>
</body>
</html>