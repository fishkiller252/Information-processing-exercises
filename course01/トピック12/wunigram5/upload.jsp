<%-- b1013236 齊藤正宏 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="java.util.Map.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="UploadServlet">
<input type="file" name="uploadfile"/>
<input type="submit" value="アップロード"/>

<table border="1">
	<tr>
		<th><input type="submit" name="sort" value="word"/></th>
		<th><input type="submit" name="sort" value="count"/></th>
	</tr>
	
	<%
	if (session.getAttribute("list") != null) {
		
		@SuppressWarnings("unchecked")
		List<Entry<String, Integer>> entries = 
				(List<Entry<String, Integer>>) session.getAttribute("list");
		for (Entry<String, Integer> entry : entries) {
			out.print("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
		}
		
		session.setAttribute("unigram", session.getAttribute("unigram"));
	}
	%>
</table>

</form>
</body>
</html>