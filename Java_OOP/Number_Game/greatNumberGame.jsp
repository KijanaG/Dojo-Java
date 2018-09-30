<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Great Number Game</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>Guess a number between 1 and 100</h1>
	<form action="/Number_Game/guess" method="POST">
		<input type="number" name="number" min="1" max="100" />
		<button type="submit"> CHECK </button>
	</form>
	<c:if test="${guess != '0' }">
		<c:choose>
			<c:when test="${guess > random}">
				<h3> Too High...</h3>
			</c:when>
			<c:when test="${guess < random}">
				<h3> Too Low...</h3>
			</c:when>
			<c:otherwise>
				<h3>Got it!!! (${random})</h3>
			<form action="/Number_Game/reset" method="GET">
				<button type="submit"> RESET </button>
			</form>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>