<%@ page pageEncoding="UTF-8"%>
<div class="common_left">
	<div class="common_welcome">
		<ul>
			<li>
				欢迎您！
			</li>
			<li>
				${user.expertId }
			</li>
			<li>
				${user.expertName }
			</li>
			<li>
				<a href="${pageContext.request.contextPath }/index.jsp">安全退出</a>
			</li>
		</ul>
	</div>
	<div class="common_menu">
		<div>
			<span>实验管理</span>
			<ul>
				<li><a href="${pageContext.request.contextPath }/ExpertServlet?cmd=noestimatelist">查看未评审项目</a></li>
				<li><a href="${pageContext.request.contextPath }/ExpertServlet?cmd=viewpass">查看已通过项目</a></li>
			</ul>
		</div>
	</div>
</div>