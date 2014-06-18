<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xmlTest</title>
<script type="text/javascript" src="jQuery/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function getInfo() {
		$.post("getJsonAction.action",
		{
			name:$("#name").val()
		},
		function (returnedData, status) {
			if("success" == status) {
				
			}
		});
	}
	function getAllInfo() {
		$.post("getGsonAction.action",{},
		function (returnedData, status) {
			if("success" == status) {
				//alert(returnedData[0].address.homeAddress + "  " + returnedData[0].friends[1].name);
				//如果是字符串的时候就要用eval方法转换
				var obj = "{name:'zhangsan'}";
				var jsonObj = eval("(" + obj + ")");
				//alert(jsonObj.name);
				
				var obj2 = {name : 'zhangsan'};
				alert(obj2.name);
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
<br>
<input type="button" value="get all info" onclick="getAllInfo();">
</body>
</html>