<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Questions Dashboard</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1>Questions Dashboard</h1>
	<br>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="q">
					<tr>
						<td><a href="/questions/${q.value.get(q.value.size()-1)}"><c:out value="${q.key}" /></a></td>
						<td>
							<c:forEach items="${q.value}" var="tag">
								<c:if test="${q.value.indexOf(tag) != q.value.size()-1}">
									<c:out value="${tag}" />	
								</c:if>
									<c:if test="${q.value.indexOf(tag) != q.value.size()-1 && q.value.indexOf(tag) != q.value.size()-2}">
									,
									</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3 class="float-right"> <a href="/questions/new">New Question</a> </h3>
	</div>
</body>
</html>