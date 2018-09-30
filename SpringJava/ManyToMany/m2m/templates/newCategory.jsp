<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Category</title>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<h1> New Category </h1>
	<form:form method="post" modelAttribute="category" action="/categories/new">
	<div class="container">
		<table class="table table-striped table-dark">
			<tbody>
				<tr>
				<td><form:label path="name">Name:</form:label> </td>
				<td><form:input type="text" path="name"/></td>
				</tr>
				<tr>
				<td></td>
				<td><form:button type="submit">Create</form:button></td>
				</tr>
			</tbody>
		</table>
	</div>
	</form:form>
</body>
</html>