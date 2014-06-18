<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票</title>
</head>
<body>
	<h1 style="color: red;">请选择喜欢的运动项目</h1>
	<s:form action="viewResult">
		<s:checkbox name="interest" label="足球" fieldValue="football"
			labelposition="left"></s:checkbox>
		<s:checkbox name="interest" label="篮球" fieldValue="basketball"
			labelposition="left"></s:checkbox>
		<s:checkbox name="interest" label="排球" fieldValue="volleyball"
			labelposition="left"></s:checkbox>
		<s:checkbox name="interest" label="羽毛球" fieldValue="badminton"
			labelposition="left"></s:checkbox>
		<!-- 
		<s:checkboxlist list="#{'computer':'计算机','math':'数学' }" name="interest" label="浪曦" labelposition="top"></s:checkboxlist>
		 -->
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>