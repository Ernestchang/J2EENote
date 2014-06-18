<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
	<center>
		<!-- EmpController extends AbstractCommandController -->
<!-- 		<form action="add.test" method="post"> -->

		<!-- EmpFormController extends SimpleFormController -->
<!-- 		<form action="" method="post"> -->

<%-- 		<form action="${pageContext.request.contextPath }/add_emp.test" method="post"> --%>

		<form action="${pageContext.request.contextPath }/add.test?func=add_emp" method="post">
			empNo:<input name="empNo" type="text"><br>
			name:<input name="name" type="text"><br>
			phone:<input name="phone" type="text"><br>
			hireDate:<input name="hireDate" type="text"><br>
			department:<select name="dept">
				<c:forEach items="${deptList }" var="dept">
					<option value="${dept }">${dept }</option>
				</c:forEach>
			</select><br>
			<input type="submit" value="submit">
		</form>
	</center>
</body>
</html>