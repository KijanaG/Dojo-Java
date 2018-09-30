<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<br>
	<form:form method="post" modelAttribute="dojo" action="/dojos/new">
		<form:label path="name">Name: <form:input type="text" path="name" /> </form:label>
		<form:button type="submit"> Create Dojo</form:button>
	</form:form>
	
</body>
</html>