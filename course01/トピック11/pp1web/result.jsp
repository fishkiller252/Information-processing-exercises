<%-- 学籍番号 氏名 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Page</title>
</head>
<body>
<div style="font-style:italic; color:blue;">
<%
String s = request.getParameter("message");
if (s == null || "".equals(s)) s = "Java";
%>
Hello <%= s %>
</div>
</body>
</html>