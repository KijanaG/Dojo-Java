<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h3 style="color:red;"> <c:out value="${error}" /> </h3>
	<form method="post" action="code">
		<label>What is the code?</label>
		<input type="text" name="code" />
		<button> Try Code</button>
	</form>
</body>
</html>