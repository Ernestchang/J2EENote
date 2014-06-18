<%@ page pageEncoding="UTF-8"%>
<div class="common_left">
	<div class="common_welcome">
		<ul>
			<li>
				欢迎您！
			</li>
			<li>
				${user.teacherId }
			</li>
			<li>
				${user.teacherName }
			</li>
			<li>
				<a href="${pageContext.request.contextPath }/index.jsp">安全退出</a>
			</li>
		</ul>
	</div>
	<div class="common_menu">
		<div>
			<span> 实验管理 </span>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/TeacherServlet?cmd=viewpass">查看实验项目</a>
				</li>
			</ul>
		</div>
	</div>
</div>