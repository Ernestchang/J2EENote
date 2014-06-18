<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>综合性、设计性实验项目鉴定</title>
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0">
		<link href="css/common.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$( "#accordion" ).accordion({
					autoHeight: false,
					navigation: true
				});
			});
		</script>
	</head>
	<body>
		<%--顶部 --%>
		<label id="information" style="display: none;">${information }</label>
		<div class="common_top"></div>
		<div class="common_center">
			<%--左边 --%>
			<jsp:include page="/WEB-INF/page/${userType }/left.jsp"></jsp:include>
			<%--右边 --%>
			<div class="common_right">
				<div class="common_position">
					<ul><li>当前位置--查看项目详情</li></ul>
				</div>
				<div class="common_content">
					<div class="noquery_overflow">
						<jsp:include page="/WEB-INF/page/common/experiment_detail.jsp"></jsp:include>
	                    <div class="estimate_detail">
							<div id="accordion" style="margin-bottom: 20px;">
								<c:forEach var="opinion" items="${opinionList }" varStatus="status">
									<h3><a href="#section${status.count }">专家鉴定意见${status.count }</a></h3>
									<div><p>${opinion }</p></div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%--底部 --%>
		<jsp:include page="/WEB-INF/page/common/bottom.jsp"></jsp:include>
	</body>
</html>
