<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify!</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min/.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
	<div class="container">
		<a href="/songs/new"> Add New </a> &nbsp; <a href="/ratings"> Top Songs </a>
		<form:form action="/search" method="get">
			<input type="text" name="artist" placeholder="Search Artist">
			<button type="submit">Search Artist</button>
		</form:form>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
				<td><a href="/songs/${song.id}"><c:out value="${song.title}" /></a></td>
				<td><c:out value="${song.rating}" /></td>
				<td> 
					<form method="post" action="/delete/${song.id}">
						<input type="hidden" value="delete" name="_method"/>
						<button type="submit">Delete</button>
					</form> 
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>