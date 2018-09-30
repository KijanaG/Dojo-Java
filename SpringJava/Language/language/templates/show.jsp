<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title> <c:out value="${language.name}" /> </title>
</head>
<body>
	<div class="container">
		<h3 class=""><a href="/languages"> Dashboard </a></h3>
		<br>
		<h1> <c:out value="${language.name}"></c:out> </h1>
		<br>
		<h1> <c:out value="${language.creator}"></c:out> </h1>
		<br>
		<h1> <c:out value="${language.currentVersion}"></c:out> </h1>
		<br>
		<a href="/languages/edit/${language.id}"> Edit </a>
		<form:form action="/languages/${language.id}" method="delete" class="form">
			<input type="submit" value="Delete" />
		</form:form>
	</div>
</body>
</html>