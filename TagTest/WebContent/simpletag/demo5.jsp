<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.simpletag.com" prefix="bingo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>开发带属性的标签</title>
</head>
<body>
<bingo:demo5 count="3" date="<%=new Date() %>">bingo&nbsp;</bingo:demo5>
</body>
</html>