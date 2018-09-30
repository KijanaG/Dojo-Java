<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile Page</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1> <c:out value="${first} ${last}" /> </h1>
	<br>
	<h3>License Number:  <c:out value="${license}" /> </h3>
	<h3>State: <c:out value="${state}" /> </h3>
	<h3>Expiration Date: <c:out value="${exp}" /></h3>
</body>
</html>