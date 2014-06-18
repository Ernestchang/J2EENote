<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<frameset framespacing="0" frameborder="no" border="0" rows="37,*,20">
	<frame scrolling="no" noresize="noresize" src='<s:url action="header" namespace="control/center"/>' />
	<frameset name="middle" framespacing="0" frameborder="no" border="0" cols="147,6,*">
		<frame scrolling="no" noresize="noresize" src='<s:url action="menu" namespace="control/center"/>' />
		<frame scrolling="no" noresize="noresize" src='<s:url action="hidden" namespace="control/center"/>' />
		<frame scrolling="no" noresize="noresize" name="content" src='<s:url action="content" namespace="control/center"/>' />
	</frameset>
	<frame scrolling="no" noresize="noresize" src='<s:url action="footer" namespace="control/center"/>' />
</frameset>
<noframes></noframes>
</html>