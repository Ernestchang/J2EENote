<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xmlTest</title>
<script type="text/javascript" src="jQuery/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function getInfo() {
		$.post("getXmlAction.action",
		{
			name:$("#name").val()
		},
		function (returnedData, status) {
			if("success" == status) {
				var id = $(returnedData).find("id").text();
				var name = $(returnedData).find("name").text();
				var age = $(returnedData).find("age").text();
				var address = $(returnedData).find("address").text();
				var html = "<table border='1'><tr><th>id</th><th>name</th><th>age</th><th>address</th></tr>" + 
				"<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + address + "</td></tr></table>"
				$("body table:eq(0)").remove();
				$("#theBody").append(html);
			}
		});
	}
</script>
</head>
<body id="theBody">
<select id="name">
	<option value="zhangsan" selected="selected">zhangsan</option>
	<option value="lisi">lisi</option>
</select>
<input type="button" value="get info" onclick="getInfo();">
</body>
</html>