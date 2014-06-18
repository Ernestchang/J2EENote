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
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var information = $("#information").text();
				if(information) {
					alert(information);
				}
				var $courseName = $("#courseName");
				var $specialtyName = $("#specialtyName");
				var $specialtyId = $("#specialtyId");
				var $courseId = $("#courseId");
				var $docPath = $("#docPath");
	
				var $courseDiv = $("#courseDiv");
				var $courseDeptId = $("#courseDeptId");
				var $course = $("#course");
				var $specialtyDiv = $("#specialtyDiv");
				var $specialtyDeptId = $("#specialtyDeptId");
				var $specialty = $("#specialty");
				$specialtyDiv.dialog( {
					show : 'blind',
					bgiframe : false,
					autoOpen : false,
					draggable : false,
					resizable : false,
					width : 300,
					height : 60
				});
				$courseDiv.dialog( {
					show : 'blind',
					bgiframe : false,
					autoOpen : false,
					draggable : false,
					resizable : false,
					width : 300,
					height : 60
				});
				$courseName.bind("click", function(event) {
					event.stopPropagation();
					$("*").stop(false, true);
					$specialtyDiv.dialog("close");
					$courseDiv.dialog("close");
					var scrollTop = $(document).scrollTop();
					var scrollLeft = $(document).scrollLeft();
					var top = $(event.target).offset().top + $(event.target).height() - scrollTop + 5;
					var left = $(event.target).offset().left - scrollLeft;
					$courseDiv.dialog("option", "position", [ left, top ]);
					$courseDiv.dialog("open");
				});
				$specialtyName.bind("click", function(event) {
					$("*").stop(false, true);
					$courseDiv.dialog("close");
					$specialtyDiv.dialog("close");
					event.stopPropagation();
					var scrollTop = $(document).scrollTop();
					var scrollLeft = $(document).scrollLeft();
					var top = $(event.target).offset().top + $(event.target).height() - scrollTop + 5;
					var left = $(event.target).offset().left - scrollLeft;
					$specialtyDiv.dialog("option", "position", [ left, top ]);
					$specialtyDiv.dialog("open");
				});
				$courseDiv.bind("click", function(event) {
					event.stopPropagation();
				});
				$specialtyDiv.bind("click", function(event) {
					event.stopPropagation();
				});
				$(document).bind("click", function(event) {
					$courseDiv.dialog("close");
					$specialtyDiv.dialog("close");
				});
				$courseDeptId.bind("change", function(event) {
					event.stopPropagation();
					$("#course option[value!='']").remove();
					$courseName.val("");
					$courseId.val("");
					var deptId = $courseDeptId.val();
					if (deptId != "") {
						$.post("HeadmanServlet?cmd=getCourseJSON&deptId=" + deptId,function(data, textStatus) {
							var dataObj = eval("(" + data + ")");
							for ( var i = 0; i < dataObj.length; i++) {
								var courseId = dataObj[i].courseId;
								var courseName = dataObj[i].courseName;
								var $option = $("<option></option>");
								$option.attr("value", courseId);
								$option.text(courseName);
								$course.append($option);
							}
						});
					}
				});
				$course.bind("change", function(event) {
					event.preventDefault();
					event.stopPropagation();
					var courseId = $("#course option:selected").val();
					var courseName = $("#course option:selected").text();
					if (courseId != "") {
						$courseName.val($("#course option:selected").text());
						$courseId.val(courseId);
						$("#courseName+label").css({"display":"none"});
					} else {
						$courseName.val("");
						$courseId.val("");
					}
				});
				$specialtyDeptId.bind("change", function(event) {
					event.stopPropagation();
					$("#specialty option[value!='']").remove();
					$specialtyName.val("");
					$specialtyId.val("");
					$("#deptName").val("");
					var deptId = $specialtyDeptId.val();
					if (deptId != "") {
						$.post("HeadmanServlet?cmd=getSpecialtyJSON&deptId=" + deptId, function(data, textStatus) {
							var dataObj = eval("(" + data + ")");
							for ( var i = 0; i < dataObj.length; i++) {
								var specialtyId = dataObj[i].specialtyId;
								var specialtyName = dataObj[i].specialtyName;
								var $option = $("<option></option>");
								$option.attr("value", specialtyId);
								$option.text(specialtyName);
								$specialty.append($option);
							}
						});
					}
				});
				$specialty.bind("change", function(event) {
					event.preventDefault();
					event.stopPropagation();
					var specialtyId = $("#specialty option:selected").val()
					var specialtyName = $("#specialty option:selected").text()
					if (specialtyId != "") {
						$specialtyName.val(specialtyName);
						$specialtyId.val(specialtyId);
						$("#deptName").val($("#specialtyDeptId option:selected").text());
						$("#specialtyName+label").css({"display":"none"});
					} else {
						$specialtyName.val("");
						$specialtyId.val("");
						$("#deptName").val("");
					}
				});
				$.validator.addMethod("opentime",function(value,element,params){ 
			    	var schoolYear = $("#addForm select[name='schoolYear']").val();
			    	var schoolTerm = $("#addForm select[name='schoolTerm']").val();
					if(schoolYear && schoolTerm) {
					   return true;
				   } else {
					   return false;
				   }
				});		
				$("#addForm").validate( {
					rules : {
						courseName : "required",
						experimentName : "required",
						specialtyName : "required",
						schoolTerm : "opentime",
						experimentCategory : "required",
						creditHours : "required",
						experimentDemand : "required", 
						experimentType : "required",
						docPath : {required:true,accept:"doc"},
						introduction : "required"
					},
					messages : {
						courseName : "课程名称不能为空",
						experimentName : "实验名称不能为空",
						specialtyName : "适用专业不能为空",
						schoolTerm : "首开时间不能为空",
						experimentCategory : "实验类别不能为空",
						creditHours : "实验学时不能为空",
						docPath : {required : "项目文档不为空",accept : "只能上传doc格式的文档"},
						introduction : "项目介绍不能为空"
					}
				});
				$("#common_submit").bind("click", function(event) {
					if ($("#specialtyDeptId").val()!=$("#courseDeptId").val()) {
						alert("<" + $("#specialtyName").val() + ">专业没有开设<" + $("#courseName").val() + ">这门课");
						return false;
					}
					return true;
				});
			});
		</script>
	</head>
	<body>
		<%--添加成功与失败信息 --%>
		<label id="information" style="display: none;">${information }</label>
		<%--顶部 --%>
		<div class="common_top"></div>
		<div class="common_center">
			<%--左边 --%>
			<jsp:include page="/WEB-INF/page/headman/left.jsp"></jsp:include>
			<%--右边 --%>
			<div class="common_right">
				<div class="common_position">
					<ul><li>当前位置--添加实验项目</li></ul>
				</div>
				<div class="common_content">
					<form action="${pageContext.request.contextPath }/AddExperimentServlet?cmd=addExperiment" method="post" enctype="multipart/form-data" id="addForm">
						<table class="add_table">
							<tr>
								<td width="60">课程名称</td>
								<td>
									<input type="hidden" id="courseId" name="courseId">
									<input class="add_input" type="text" id="courseName" name="courseName" readonly="readonly">
									<label style="display:none;" for="course" class="error"></label>
								</td>
							</tr>
							<tr>
								<td>项目名称</td>
								<td><input class="add_input" type="text" name="experimentName" id="experimentName"></td>
							</tr>
							<tr>
								<td>适用专业</td>
								<td>
									<input type="hidden" id="specialtyId" name="specialtyId">
									<input type="hidden" id="deptName" name="deptName">
									<input class="add_input" type="text" id="specialtyName" name="specialtyName" readonly="readonly">
								</td>
							</tr>
							<tr>
								<td>首开时间</td>
								<td>
									<select name="schoolYear">
										<option selected="selected" value="">--请选择学年--</option>
										<c:forEach var="openTime" items="${openTimeList }">
											<option value="${openTime.schoolYear }">${openTime.schoolYear }</option>
										</c:forEach>
									</select>&nbsp;&nbsp;
									<select name="schoolTerm">
										<option selected="selected" value="">--请选择学期--</option>
										<c:forEach var="temp" begin="1" end="3">
											<option value="${temp }">${temp }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>实验类别</td>
								<td>
									<select name="experimentCategory">
										<option selected="selected" value="">--请选择--</option>
										<option value="基础">基础</option>
										<option value="专业基础">专业基础</option>
										<option value="专业">专业</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>实验学时</td>
								<td>
									<select name="creditHours">
										<option selected="selected" value="">--请选择--</option>
										<c:forEach var="temp" begin="1" end="6">
											<option value="${temp }">${temp }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>实验要求</td>
								<td>
									<input id="demand1" type="radio" name="experimentDemand" value="必修">
									<label for="demand1">必修</label>
									<input id="demand2" type="radio" name="experimentDemand" value="选修">
									<label for="demand2">选修</label>
									<label style="display:none;" for="experimentDemand" class="error">实验要求不能为空</label>
								</td>
							</tr>
							<tr>
								<td>项目类型</td>
								<td>
									<input id="type1" type="radio" name="experimentType" value="综合性">
									<label for="type1">综合性</label>
									<input id="type2" type="radio" name="experimentType" value="设计性">
									<label for="type2">设计性</label>
									<label style="display:none;" for="experimentType" class="error">项目类型不能为空</label>
								</td>
							</tr>
							<tr>
								<td>项目文档</td>
								<td>
									<input class="add_input" type="file" name="docPath" id="docPath">
								</td>
							</tr>
							<tr>
								<td>项目介绍</td>
								<td>
									<textarea class="add_input" name="introduction" id="introduction"></textarea>
								</td>
							</tr>
						</table>
						<div align="center">
							<input type="submit" value="" id="common_submit">
							<input type="reset" value="" id="common_reset">
						</div>
					</form>	
					<div id="courseDiv" title="请选择课程">
						<select class="add_input" id="courseDeptId">
							<option value="" selected="selected">请选择系别</option>
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptId }">${dept.deptName }</option>
							</c:forEach>
						</select>
						&nbsp;&nbsp;
						<select class="add_input" id="course" name="course">
							<option value="" selected="selected">请选择课程</option>
						</select>
					</div>
					<div id="specialtyDiv" title="请选择专业">
						<select class="add_input" id="specialtyDeptId">
							<option value="" selected="selected">请选择系别</option>
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptId }">${dept.deptName }</option>
							</c:forEach>
						</select>
						&nbsp;&nbsp;
						<select class="add_input" id="specialty">
							<option value="">请选择专业</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<%--底部 --%>
		<jsp:include page="/WEB-INF/page/common/bottom.jsp"></jsp:include>
	</body>
</html>
