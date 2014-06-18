<%@ page pageEncoding="UTF-8"%>
<table class="experiment_detail">
	<tr>
		<td width="69">课程名称</td><td width="229">${experiment.courseName }</td>
		<td width="69">项目名称</td><td width="328">${experiment.experimentName }</td>
	</tr>
	<tr align="center"><td>实验类别</td><td>${experiment.experimentCategory }</td><td>首开时间</td><td>${experiment.schoolYear }学年第${experiment.schoolTerm }学期</td></tr>
	<tr><td>实验要求</td><td>${experiment.experimentDemand }</td><td>适用专业</td><td>${experiment.specialtyName }</td></tr>
	<tr><td>实验学时</td><td>${experiment.creditHours }</td><td>项目类型</td><td>${experiment.experimentType }</td></tr>
	<tr>
		<td height="120">实验<br>项目<br>总体<br>介绍</td>
		<td colspan="3" width="628" height="120"><span>${experiment.introduction }</span></td>
	</tr>
</table>
<form action="DownloadServlet" target="_blank">
<input type="hidden" name="experimentId" value="${experiment.experimentId }">
<div class="download_div"><input id="download" type="submit" value="" onFocus="this.blur()"></div>
</form>