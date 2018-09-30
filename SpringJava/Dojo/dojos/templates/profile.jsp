<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Page</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1> <c:out value="${name}" /> Location Ninjas</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ninjas}" var="ninja">
			<tr>
				<td> <c:out value="${ninja.firstName}" /> </td>
				<td> <c:out value="${ninja.lastName}" /> </td>
				<td> <c:out value="${ninja.age}" /> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>