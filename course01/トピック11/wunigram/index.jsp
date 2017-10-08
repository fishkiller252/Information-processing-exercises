<%-- 学籍番号 氏名 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="unigram.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unigram</title>
</head>
<body>

<form>
<textarea name="inputtext"></textarea><br/>
<input type="submit" value="↓">
</form>

<%
String text = request.getParameter("inputtext");
if (text != null && !"".equals(text)) {
	List<String> list = Arrays.asList(text.split("\n"));
	ArrayList<String> arrayList = new ArrayList<String>(list);
	Unigram unigram = new Unigram(arrayList);
	
	Map<String, Integer> sortedMap =
			new TreeMap<String, Integer>(unigram.getFrequencies());
	
	out.print("<table border='1'><tr><th>word</th><th>count</th></tr>");
	for (String key : sortedMap.keySet()) {
		int value = sortedMap.get(key);
		out.print("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
	}
	out.print("</table>");
}
%>

</body>
</html>