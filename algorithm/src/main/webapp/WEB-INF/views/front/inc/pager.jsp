<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="wp-pagenavi">
	<c:if test="${pagerJson.currentIndex > 1}">
		<a href="javascript:topage(1)" title="1">首页</a>
		<a href="javascript:topage(${pagerJson.currentIndex - 1 })" title="${pagerJson.currentIndex - 1}">上一页</a>
	</c:if>

	<c:forEach begin="${pagerJson.beginIndex}" end="${pagerJson.endIndex}" var="index" varStatus="status">
		<c:if test="${pagerJson.currentIndex == index}">
			<span class="current">${index}</span>
		</c:if>
		<c:if test="${pagerJson.currentIndex != index}">
			<a href="javascript:topage(${index})" title="${index}">${index}</a>
		</c:if>
	</c:forEach>

	<c:if test="${pagerJson.currentIndex < pagerJson.endIndex}">
		<a href="javascript:topage(${pagerJson.currentIndex + 1 })" title="${pagerJson.currentIndex + 1}">下一页</a>
		<a href="javascript:topage(${pagerJson.totalPage})" title="${pagerJson.totalPage}">尾页</a>
	</c:if>
</div>