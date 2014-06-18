<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,cn.wh.ejb3.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
try {
	InitialContext ctx = new InitialContext();
	HelloWorldLocal helloWorld = (HelloWorldLocal) ctx.lookup("HelloWorldBean/local");
	System.out.println(helloWorld.getClass().getName());
	out.println(helloWorld.sayHello("本地人"));
} catch (Exception e) {
	out.println(e.getMessage());
}
%>
</body>
</html>