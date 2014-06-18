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
				var information = $("#information").text();
				if(information) {
					alert(information);
					$("#common_submit").attr("disabled", true);
				}
				$("#deptId").change(function() {
					$("#specialtyId option[value!='']").remove();
					var deptId = this.value;
					if(deptId != "") {
						$.post("ManagerServlet",{cmd:"getSpecialtyJSON",deptId:deptId},function(data,textStatus) {						
							var dataObj = eval("("+data+")");
							for ( var i = 0; i < dataObj.length; i++) {
								var specialtyId = dataObj[i].specialtyId;
								var specialtyName = dataObj[i].specialtyName;
								var $option = $("<option></option>");
								$option.attr("value", specialtyId);
								$option.text(specialtyName);
								$("#specialtyId").append($option);
							}
						});
					}
				});
				
				$("#specialtyId").bind("change", function(event) {
					$("#first tr").remove();
					$("#second tr").remove();
					var specialtyId = $("#specialtyId option:selected").val();
					$.post("ManagerServlet",{cmd:"getExpertJSON",specialtyId:specialtyId},function(data,textStatus) {						
						var dataObj = eval("("+data+")");
						for ( var i = 0; i < dataObj.length; i++) {
							var $firstTr = $("<tr></tr>");
							var $checkTd = $("<td width='79'></td>");
							var $checkbox = $("<input></input>");
							$checkbox.attr("type","checkbox");
							$checkbox.attr("name","expertId");
							$checkbox.attr("value",dataObj[i].expertId);
							$checkTd.append($checkbox);
							var $nameTd = $("<td></td>");
							$nameTd.text(dataObj[i].expertName);
							$firstTr.append($checkTd);
							$firstTr.append($nameTd);
							$firstTr.appendTo($("#first"));
						}
					});
				});
				
				$("#first input[type=checkbox]").live("click", function(event) {
					var $this = $(this);
					var isChecked = $this.attr("checked");
					var firstId = $this.val();
					if (isChecked) {
						var $firstTr = $this.parent().parent();
						var expertName = $firstTr.children().eq(1).text();
						var $secondTr = $("<tr></tr>");
						var $checkTd = $("<td width='79'></td>");
						var $checkbox = $("<input></input>");
						$checkbox.attr("type","checkbox");
						$checkbox.attr("checked",true);
						$checkbox.attr("value",firstId);
						$checkTd.append($checkbox);
						var $nameTd = $("<td></td>");
						$nameTd.text(expertName);
						$secondTr.append($checkTd);
						$secondTr.append($nameTd);
						$secondTr.appendTo($("#second"));
					} else {
						$("#second input[type=checkbox]").each(function(index, domElement) {
							var $this = $(this);
							var secondId = $this.val();
							if (firstId == secondId) {
								$this.parent().parent().remove();
							}
						});
					}
				});
				$("#second input[type=checkbox]").live("click", function(event) {
					var $this = $(this);
					var secondId = $this.val();
					$this.parent().parent().remove();
					$("#first input[type=checkbox]").each(function(index, domElement) {
						var firstId = $(this).val();
						if (firstId == secondId) {
							$(this).attr("checked",false)
						}
					});
				});
				$("#common_reset").bind("click", function(event) {
					$("#first tr").remove();
					$("#second tr").remove();
				});
				$("#common_submit").bind("click", function(event) {
					var $checked = $("#first input[type=checkbox]:checked");
					var length = $checked.length;
					if(length!=3) {
						alert("必须选择三位评审专家");
						return false;
					} else {
						return true;
					}
				});
				
			});
		</script>
	</head>
	<body>
		<label id="information" style="display: none;">${information }</label>
		<%--顶部 --%>
		<div class="common_top"></div>
		<div class="common_center">
			<%--左边 --%>
			<jsp:include page="/WEB-INF/page/manager/left.jsp"></jsp:include>
			<%--右边 --%>
			<div class="common_right">
				<div class="common_position">
					<ul><li>当前位置--分发实验项目</li></ul>
				</div>
				<div class="common_content">
					<div class="noquery_overflow">
						<jsp:include page="/WEB-INF/page/common/experiment_detail.jsp"></jsp:include>
							<form action="DistributeServlet?cmd=distribute" method="post">
							<input type="hidden" name="experimentId" value="${experiment.experimentId }">
							<table class="distribute_table">
								<tr><td colspan="4" height="30">
									<select id="deptId">
										<option value="" selected="selected">请选择系别</option>
										<c:forEach var="dept" items="${deptList }">
											<option value="${dept.deptId }">${dept.deptName }</option>
										</c:forEach>
									</select>
									<select id="specialtyId"><option value="">请选择从事专业</option></select>
								</td></tr>
								<tr><td width="80">选择</td><td width="268">姓名</td><td width="80">取消</td><td>姓名</td></tr>
								<tr>
									<td width="350" height="200" valign="top" colspan="2">
										<table id="first" width="200"></table>
									</td>
									<td colspan="2" align="right" valign="top">
										<table id="second" width="200"></table>
									</td>
								</tr>
								<tr><td colspan="4" valign="middle" height="50" style="border:0px;">
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
