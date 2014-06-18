<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>综合性、设计性实验项目鉴定</title>
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0">
		<link href="css/common.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var information = $("#information").text();
				if(information) {
					alert(information);
					$("#common_submit").attr("disabled", true);
				}
				$("#common_submit").bind("click", function(event) {
					var opinion = $("#opinion").val();
					if(!opinion) {
						alert("请填写评审意见");
						return false;
					}
					var $experimentType = $(".estimate_table input:radio[name=experimentType]:checked");
					var experimentType = $experimentType.val();
					if(!experimentType) {
						alert("请选择项目类型");
						return false;
					}
					var $appraisalStatus = $(".estimate_table input:radio[name=appraisalStatus]:checked");
					var appraisalStatus = $appraisalStatus.val();
					if(!appraisalStatus) {
						alert("请选择该实验是否能通过");
						return false;
					}
					return true;
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
			<jsp:include page="/WEB-INF/page/expert/left.jsp"></jsp:include>
			<%--右边 --%>
			<div class="common_right">
				<div class="common_position">
					<ul><li>当前位置--评审实验项目</li></ul>
				</div>
				<div class="common_content">
				<div class="noquery_overflow">
					<jsp:include page="/WEB-INF/page/common/experiment_detail.jsp"></jsp:include>
					<form action="${pageContext.request.contextPath }/ExpertEstimateServlet?cmd=estimate" method="post">
                    	<table class="estimate_table">
                        	<tr><td colspan="2" height="140"><textarea id="opinion" name="opinion"></textarea></td></tr>
                            <tr><td>
								<input id="type1" type="radio" name="experimentType" value="综合性">
								<label for="type1">综合性</label>
								<input id="type2" type="radio" name="experimentType" value="设计性">
								<label for="type2">设计性</label>
							</td><td>
								<input id="status1" type="radio" name="appraisalStatus" value="通过">
								<label for="status1">通过</label>
								<input id="status2" type="radio" name="appraisalStatus" value="未通过">
								<label for="status2">未通过</label>
                            </td></tr>
                            <tr><td colspan="4" valign="middle" height="50" style="border:0px;">
                            	<input type="hidden" name="experimentId" value="${experiment.experimentId }">
								<input type="submit" value="" id="common_submit">
								<input type="reset" value="" id="common_reset">
							</td></tr>
                         </table>
                	</form>
				</div>
				</div>
			</div>
		</div>
		<%--底部 --%>
		<jsp:include page="/WEB-INF/page/common/bottom.jsp"></jsp:include>
	</body>
</html>
