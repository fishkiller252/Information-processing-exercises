<%-- 学籍番号 氏名 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="java.util.Map.*" %>
<%@ page import="unigram.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unigram</title>
</head>
<body>

<form>
<textarea name="inputtext"><%
if (request.getParameter("inputtext") != null) {
	if (!request.getParameter("inputtext").equals("")) {
		out.print(request.getParameter("inputtext"));
	}
}
%></textarea><br/>
<input type="submit" value="↓">

<%
String text = request.getParameter("inputtext");

if (text != null && !"".equals(text)) {
	List<String> list = Arrays.asList(text.split(System.getProperty("line.separator")));
	ArrayList<String> arrayList = new ArrayList<String>(list);
	Unigram unigram = new Unigram(arrayList);
	
	Map<String, Integer> sortedMap =
			new TreeMap<String, Integer>(unigram.getFrequencies());
%>

<table border="1">
	<tr>
		<th><input type="submit" name="sort" value="word"/></th>
		<th><input type="submit" name="sort" value="count"/></th>
	</tr>
	
	<%
	List<Entry<String, Integer>> entries = 
			new ArrayList<Entry<String, Integer>>(sortedMap.entrySet());
	final String sort = request.getParameter("sort");
	
	Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
		public int compare(Entry<String, Integer> x, Entry<String, Integer> y) {
			if (sort == null || sort.equals("word")) {
				return x.getKey().compareTo(y.getKey());
			} else {
				return y.getValue().compareTo(x.getValue());
			}
		}
	});
	
	for (Entry<String, Integer> entry : entries) {
		out.print("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
	}
	%>
</table>

<%
}
%>

</form>
</body>
</html>