<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min/.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	
	<div>
		<h3>Songs by Artist with <span style="font-style:italic;font-weight:bold;">${artist}</span> in their name:</h3>
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
				<td> <a href="/delete/${song.id}"> Delete </a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>