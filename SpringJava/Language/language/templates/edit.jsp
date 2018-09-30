<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ page isErrorPage="true" %> 
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title><c:out value="${language.name}" /></title>
</head>
<body>
	<div class="container">
		<nav class="nav"> 
		<form:form action="/languages/${language.id}" method="delete" class="form">
			<input type="submit" value="Delete" />
		</form:form>
		<a href="/languages"> Dashboard </a>
		</nav>
		<form:form action="/languages/${language.id}" method="put" modelAttribute="language" class="form">
		    <!-- <input type="hidden" name="_method" value="put"> -->
		    <div class="form-group">
		        <form:label path="name">Name: </form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="creator">Creator: </form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </div>
		    <div class="form-group">
		        <form:label path="currentVersion">Version: </form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </div>
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>