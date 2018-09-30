<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ page isErrorPage="true" %> <!-- Allows us to render errors on PUT request -->
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>Edit Book</h1>
	<form:form action="/books/${book.id}" method="put" modelAttribute="book">
	    <!-- <input type="hidden" name="_method" value="put"> -->
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>
	    <p>
	        <form:label path="language">Language</form:label>
	        <form:errors path="language"/>
	        <form:input path="language"/>
	    </p>
	    <p>
	        <form:label path="numberOfPages">Pages</form:label>
	        <form:errors path="numberOfPages"/>     
	        <form:input type="number" path="numberOfPages"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>