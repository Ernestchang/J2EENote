<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>自定义上传文件个数</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript">
			function addMore() {
				var td = document.getElementById("more");
				//换行
				var br = document.createElement("br");
				var file = document.createElement("input");
				file.type = "file";
				file.name = "file";
				var remove = document.createElement("input");
				remove.type = "button";
				remove.value = "remove";
				
				remove.onclick = function() {
					td.removeChild(file);
					td.removeChild(remove);
					td.removeChild(br);
				}
				
				td.appendChild(file);
				td.appendChild(remove);
				td.appendChild(br);
			}
		</script>
	</head>
	<body>
		<center>
		<!--
			这几个name必须是一样的
		-->
		<form action="upload3.action" method="post" enctype="multipart/form-data">
			username:<input type="text" name="username"><br>
			<div id="more">
			<input type="file" name="file"><br>
			</div>
			<input type="button" value="Add more.." onclick="addMore()"><br>
			<input type="submit" value="upload">
		</form>
		</center>
	</body>
</html>