<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Show Page</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1><c:out value="${book.title}"></c:out></h1>
	<br>
	<h4>Description: <c:out value="${book.description}"></c:out></h4>
	<br>
	<h3>Language: <c:out value="${book.language}"></c:out></h3>
	<br>
	<h3>Number of pages taken L'sss: <c:out value="${book.numberOfPages}"></c:out></h3>
	<br>
	<a href="/books/${book.id}/edit">Edit Book</a>
	<form action="/books/${book.id}" method="post">
		<input type="hidden" name="_method" value="delete" >
		<input type="submit" value="Delete" >
	</form>
</body>
</html>