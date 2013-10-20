<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar">
	<h1>全部算法</h1>
	<div data-role="collapsible-set" data-theme="b" data-content-theme="c"
		data-collapsed-icon="arrow-r" data-expanded-icon="arrow-d"
		style="margin: 0; width: 250px;">
		<c:forEach items="${topChannels }" var="topChannel">
			<div data-role="collapsible" data-inset="false">
				<h2>${topChannel.name }</h2>
				<ul data-role="listview">
					<c:forEach items="${topChannel.childrens }" var="channel">
						<li><a href="#" data-mini="true" data-inline="true">${channel.name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</div>
</div>