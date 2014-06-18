<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>多文件上传结果</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<center>
		<!-- 如果元素不是根元素，必须加一个#号 告诉ognl它不是一个根元素-->
		 username:<s:property value="username"/><br>
		 <s:iterator value="fileFileName" id="f" status="sta">
			 file:<s:property value="#f"/><br>
			 file:<s:property value="#f.toUpperCase()"/><br>
		 </s:iterator>
		</center>
	</body>
</html>