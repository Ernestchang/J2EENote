<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>重定向登录</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	function getInfo() {
		alert("ttt");
		$.post("xml/getXMLAction.action",
			{name:$("#name").val()},
			function(returnedData,status) {
				alert(returnedData);
				var id = $(returnedData).find("id").text();
				var name = $(returnedData).find("name").text();
				var age = $(returnedData).find("age").text();
				var address = $(returnedData).find("address").text();
				var html = "<table width='60%' border='1' align='center'>" +
				"<tr><td>id</td><td>name</td><td>age</td><td>address</td></tr>" +
				"<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+address+"</td></tr></table>";
				$("#theBody table:eq(0)").remove();
				$("#theBody").append(html);
			});
	}
</script>
</head>
<body id="theBody">
	<select id="name">
		<option value="zhangsan">zhangsan</option>
		<option value="lisi">lisi</option>
		<option value="wangwu">wangwu</option>
	</select>
	<input type="button" value="get information" onclick="getInfo();">
</body>
</html>