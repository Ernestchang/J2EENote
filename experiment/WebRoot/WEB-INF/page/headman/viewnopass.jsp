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
		<script type="text/javascript">
			$(document).ready(function() {
				$("#dept").change(function() {
					$("#course option[value!='']").remove();
					var deptId = this.value;
					if(deptId != "") {
						$.post("HeadmanServlet",{cmd:"getCourseJSON",deptId:deptId},function(data,textStatus) {						
							var dataObj = eval("("+data+")");
							for ( var i = 0; i < dataObj.length; i++) {
								var courseId = dataObj[i].courseId;
								var courseName = dataObj[i].courseName;
								var $option = $("<option></option>");
								$option.attr("value", courseId);
								$option.text(courseName);
								$("#course").append($option);
							}
						});
					}
				});
				$("#query_button").click(function(){
					var b = true;
					$("select").each(function(index,domElement) {
						if(this.value == "") {
							b = false;
						}
					});
					if(b) {
						$("#experimentList tr").remove();
						var schoolYear = $("#schoolYear").val();
						var schoolTerm = $("#schoolTerm").val();
						var courseId = $("#course").val();
						$.post("HeadmanServlet",{cmd:"queryNoPass",schoolYear:schoolYear,schoolTerm:schoolTerm,courseId:courseId},function(data,textStatus) {
							var dataObj = eval("("+data+")");
							for ( var i = 0; i < dataObj.length; i++) {
								var experimentId = dataObj[i].experimentId;
								var experimentName = dataObj[i].experimentName;
								var $tr = $("<tr></tr>");
								$tr.attr("valign","middle");
								var $experimentNameTd = $("<td></td>");
								$experimentNameTd.attr("width","580");
								$experimentNameTd.text(experimentName);
								
								var $caoZuoTd = $("<td></td>");
								var $del = $("<input type='button' value='删除'>");
								$del.attr("title",experimentId);
								$caoZuoTd.append($del);
								
								$tr.append($experimentNameTd);
								$tr.append($caoZuoTd);
								$("#experimentList").append($tr);
							}
						});
					} else {
						alert("请选择查询条件");
					}
				});
				$("#experimentList input").live("click", function(event) {
					var experimentId = $(this).attr("title");
					$.post("HeadmanServlet?cmd=delete&experimentId=" + experimentId,function(data,textStatus) {
						alert(data);
						if("success"==data) {
							$("#query_button").click();
						} else {
							alert("删除失败");
						}
					});
				});
			});
		</script>
	</head>
	<body>
	<a title=""></a>
		<%--顶部 --%>
		<div class="common_top"></div>
		
		<div class="common_center">
			<%--左边 --%>
			<jsp:include page="/WEB-INF/page/headman/left.jsp"></jsp:include>
			<%--右边 --%>
			<div class="common_right">
				<div class="common_position">
					<ul><li>当前位置--查看未通过实验项目</li></ul>
				</div>
				<div class="common_content">
					<div class="query_div">
						<span>
						<select id="schoolYear">
							<option selected="selected" value="">请选择学年</option>
							<c:forEach var="openTime" items="${openTimeList }">
								<option value="${openTime.schoolYear }">${openTime.schoolYear }</option>
							</c:forEach>
						</select>
						<select id="schoolTerm">
							<option value="" selected="selected">请选择学期</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
						<select id="dept">
							<option value="" selected="selected">请选择系别</option>
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptId }">
									${dept.deptName }
								</option>
							</c:forEach>
							</select>
							<select id="course">
								<option value="" selected="selected">请选择课程</option>
							</select>
							</span>
							<input type="button" value="" onFocus="this.blur()" id="query_button">
					</div>
					<table class="query_title">
						<tr valign="middle">
							<th width="600">项目名称</th>
							<th>操作</th>
						</tr>
					</table>
					<div class="query_overflow">
						<table id="experimentList"></table>
					</div>
				</div>
			</div>
		</div>
		<%--底部 --%>
		<jsp:include page="/WEB-INF/page/common/bottom.jsp"></jsp:include>
	</body>
</html>
