<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div class="container">
		<h1> <c:out value="${name}"/> </h1>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="container" style="display:inline-block;">
			<h3>Products: </h3>
				<ul>
					<c:forEach items="${products}" var="prod">
						<c:if test="${prod.value == true}">
							<li> <c:out value="${prod.key}" /> </li>
						</c:if>
					</c:forEach>
				</ul>
		</div>
		<div class="container" style="display:inline-block;">
			<form method="post" action="/categories/${id}">
				<label>Add Product:</label>
					<select name="product">
						<c:forEach items="${products}" var="prod">
							<c:if test="${prod.value == false}">
								<option value="${prod.key}"><c:out value="${prod.key}" /></option>
							</c:if>
						</c:forEach>
					</select>
				<button type="submit">Add</button>
			</form>
		</div>
	</div>
</body>
</html>