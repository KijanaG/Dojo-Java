<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Person</title>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/persons/new" method="post" modelAttribute="person">
		<form:label path="firstName"> First Name:  <form:input type="text" path="firstName" /></form:label>
		<form:label path="lastName"> Last Name:  <form:input type="text" path="lastName" /></form:label>
		<form:button type="submit" >Create Person</form:button>
	</form:form>
</body>
</html>