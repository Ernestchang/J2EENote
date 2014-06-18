<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/hidden.css">
		<script type="text/javascript">
		function isShowLeft(isShowLeftImg){
			if(parent.middle.cols == "147,6,*") {
				parent.middle.cols="0,6,*";
				isShowLeftImg.src="${pageContext.request.contextPath }/images/left_hidden.gif";
				isShowLeftImg.alt="打开左侧导航栏";
			} else {
				parent.middle.cols="147,6,*";
				isShowLeftImg.src="${pageContext.request.contextPath }/images/left_show.gif";
				isShowLeftImg.alt="隐藏左侧导航栏";
			}
		}
		</script>
	</head>
	<body>
		<table class="isShowLeftTable">
			<tr><td><img onclick="isShowLeft(this)" alt=隐藏左侧导航栏 src="${pageContext.request.contextPath }/images/left_show.gif"></td></tr>
		</table>
	</body>
</html> 