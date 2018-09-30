<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h3> <a href="/dashboard">Dashboard</a> </h3>
	<br>
	<h2>Title: <c:out value="${song.title}" /></h2>
	<h2>Title: <c:out value="${song.artist}" /></h2>
	<h2>Title: <c:out value="${song.rating}" /></h2>
	<form method="post" action="/delete/${song.id}">
		<input type="hidden" value="delete" name="_method"/>
		<button type="submit">Delete</button>
	</form> 
</body>
</html>