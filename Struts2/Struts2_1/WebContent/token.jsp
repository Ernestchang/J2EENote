<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>token</title>
</head>
<body>
	<center>
	<p>
	通过Session Token（Session令牌）：当客户端请求页面时，服务器会通过token标签生成一个随机数，并且
	将该随机数放置到session当中，然后将该随机数发向客户端；如果客户第一次提交，那么会将该随机数发往服务器端，服
	务器会接收到该随机数并且与session中所保存的随机数进行比较，这是两者的值是相同的，服务器认为是第一次提交，并且
	将更新服务器端的这个随机数值；如果此时再次重复提交，那么客户端发向服务器的随机数还是之前的那个，而服务器端的随机
	数则已经发生了变化，两者不同，服务器就认为这是重复提交，进而转向invalid.token所指向的结果页面
	</p>
		<s:form action="token.action">
			<s:textfield name="username" label="username"></s:textfield><br>
			<s:password name="password" label="password"></s:password><br>
			<s:token></s:token>
			<s:submit value="submit"></s:submit>
		</s:form>
	</center>
</body>
</html>