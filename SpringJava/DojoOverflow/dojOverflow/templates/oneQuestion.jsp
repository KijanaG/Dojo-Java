<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1> <c:out value="${query}" /> </h1>
		<h4 style="display:inline-block;">Tags: </h4> &nbsp;
		<c:forEach items="${tags}" var="tag">
			<div style="width:auto;height:30px;display:inline-block;box-shadow:1px 2px grey; border: 1px solid grey; padding:2px 3px; margin-right:10px;">
				<c:out value="${tag}" />
			</div>
		</c:forEach>
		<br>
		<div class="container">
			<table style="display:inline-block;" class="table table-striped">
				<thead>
					<tr>
					<th>Answers: </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${answers}" var="answer">
						<tr>
							<td> <c:out value="${answer}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form style="display:inline-block;" action="/questions/${id}" method="post">
				<h3>Add your answer: </h3>
				<label>Answer: </label>
				<textarea name="answer"></textarea>
				<button type="submit">Answer It!</button>
			</form>
		</div>
	</div>
</body>
</html>