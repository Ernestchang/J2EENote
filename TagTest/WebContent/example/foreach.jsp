<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.wh.com" prefix="wh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>迭代</title>
</head>
<body>
<%
	List<String> list = new ArrayList<String>();
	list.add("aaa");
	list.add("bbb");
	list.add("ccc");
	list.add("ddd");
	list.add("eee");
	request.setAttribute("list", list);
%>
<wh:foreach items="${list }" var="str">
${str }
</wh:foreach>
<br/>-------------------------------------List-------------------------<br/>
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("aa","111");
	map.put("bb","222");
	map.put("cc","333");
	map.put("dd","444");
	map.put("ee","555");
	map.put("ff","666");
	request.setAttribute("map", map);
%>
<wh:foreach items="${map }" var="entry">
${entry.key } = ${entry.value }
</wh:foreach>
<br/>--------------------------------------Map------------------------<br/>
<%
	Integer num[] = {1,2,3,4};
	request.setAttribute("num", num);
%>
<wh:foreach items="${num }" var="i">
${i }
</wh:foreach>
<br/>------------------------------------Integer--------------------------<br/>
<%
	int num2[] = {1,2,3,4};
	request.setAttribute("num2", num2);
%>
<wh:foreach items="${num2 }" var="j">
${j }
</wh:foreach>
<br/>---------------------------------int-----------------------------<br/>
<%
	boolean b[] = {true,false,true};
	request.setAttribute("b", b);
%>
<wh:foreach items="${b }" var="k">
${k }
</wh:foreach>
<br/>------------------------------boolean--------------------------------<br/>

</body>
</html>