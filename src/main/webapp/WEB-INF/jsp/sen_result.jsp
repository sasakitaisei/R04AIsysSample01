<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	
	Optional<String> string = 
		Optional.ofNullable((String) request.getAttribute("string"));
	double positive = 
		(double) request.getAttribute("positive");
	double neutral = 
			(double) request.getAttribute("neutral");
	double negative = 
			(double) request.getAttribute("negative");

%>

<body>
<H1>Sentiment</H1>
<H3>文章：<%= string.orElse("ERROR") %></H3>
<H3>positive：<%=positive%></H3>
<H3>neutral：<%=neutral%></H3>
<H3>negative：<%=negative%></H3>
</body>
</html>