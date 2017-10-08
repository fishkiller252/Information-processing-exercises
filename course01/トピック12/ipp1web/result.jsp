<%-- b1013236 齊藤正宏 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Page</title>
</head>
<body>
<body>
<div style="font-style:italic; color:blue">
<%
   Integer nc = (Integer)request.getAttribute("numofcharacters");
   Integer nw = (Integer)request.getAttribute("numofwords"); 
   String text = (String)request.getAttribute("text"); 
%>
<table>
<tr><td>num of characters</td><td><%= nc %></td></tr>
<tr><td>num of words</td><td><%= nw %></td></tr>
<tr><td>text</td><td><%= text %></td></tr>
</table>
</div>
</body>
</html>